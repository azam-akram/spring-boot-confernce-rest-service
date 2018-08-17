package com.test.springboot.restservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.springboot.restservice.dto.Conference;
import com.test.springboot.restservice.dto.Conferences;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class ConferenceControllerTest {

    private ObjectMapper objectMapper;

    private static final String SERVER_BASE_URL = "http://10.128.8.93";
    private static final String COLON = ":";

    @LocalServerPort
    private int PORT;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setup() {
        assertThat(PORT).isNotEqualTo(0);
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testGetAllConferences_shouldGet2Conferences() {
        ResponseEntity<Conferences> conferences = this.restTemplate.getForEntity(SERVER_BASE_URL + COLON + PORT + "/conference", Conferences.class);
        assertThat(conferences.getBody().getConferences()).isNotNull();
        assertThat(conferences.getBody().getConferences().size()).isEqualTo(2);
        assertThat(conferences.getBody().getConferences().get(0)).isNotNull();
        assertThat(conferences.getBody().getConferences().get(0).getTitle()).isEqualTo("IETF");
        assertThat(conferences.getBody().getConferences().get(0).getLocation()).isEqualTo("Stockholm");
        assertThat(conferences.getBody().getConferences().get(0).getParticipants()).isNotNull();
        assertThat(conferences.getBody().getConferences().get(0).getParticipants().size()).isEqualTo(2);
        assertThat(conferences.getBody().getConferences().get(0).getParticipants().get(0).getName()).isEqualTo("BOB");
        assertThat(conferences.getBody().getConferences().get(0).getParticipants().get(0).getEmail()).isEqualTo("bob@test.com");
    }

    @Test
    public void testGetAConferenceById_shouldGet2Conferences() {
        ResponseEntity<Conference> conference = this.restTemplate.getForEntity(SERVER_BASE_URL + COLON + PORT + "/conference/1", Conference.class);
        assertThat(conference.getBody()).isNotNull();
        assertThat(conference.getBody().getTitle()).isEqualTo("IETF");
        assertThat(conference.getBody().getLocation()).isEqualTo("Stockholm");
        assertThat(conference.getBody().getParticipants().size()).isEqualTo(1);
        assertThat(conference.getBody().getParticipants().get(0).getName()).isEqualTo("Azam");
    }

    @Test
    public void testPostAConference_shouldGetCreatedConference() throws IOException {
        Conference conference = getConferenceReadFromJsonFile();
        assertThat(conference).isNotNull();
        if(conference != null) {
            ResponseEntity<Conference> conferenceResponseEntity = this.restTemplate.postForEntity(SERVER_BASE_URL + COLON + PORT + "/conference",
                        conference, Conference.class);
            assertThat(conferenceResponseEntity.getBody()).isNotNull();
            assertThat(conferenceResponseEntity.getBody().getTitle()).isEqualTo("IETF");
            assertThat(conferenceResponseEntity.getBody().getLocation()).isEqualTo("Stockholm");
        }
    }

    @Test
    public void testPutAConference_shouldGetUpdatedConference() throws IOException {
        Conference conference = getConferenceReadFromJsonFile();
        assertThat(conference).isNotNull();
        if(conference != null) {
             this.restTemplate.put(SERVER_BASE_URL + COLON + PORT + "/conference", conference);
        }
    }

    private Conference getConferenceReadFromJsonFile() throws IOException {
        URI uri = null;
        try {
            uri = ConferenceControllerTest.class.getClassLoader().getResource("json/conference.json").toURI();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Conference conference;
        if(uri == null) {
            throw new IOException();
        }

        String json = new String(Files.readAllBytes(Paths.get(uri)), StandardCharsets.UTF_8);
        conference = objectMapper.readValue(json, Conference.class);
        return conference;
    }

}
