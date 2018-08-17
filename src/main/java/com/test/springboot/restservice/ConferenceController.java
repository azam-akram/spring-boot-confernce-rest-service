package com.test.springboot.restservice;

import com.test.springboot.restservice.dto.Conference;
import com.test.springboot.restservice.dto.Conferences;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

// TODO: Junit tests
// TODO: H2 database
// TODO: Docker
// TODO: Heroku

@RestController
@Slf4j
@RequestMapping(path = "/conference")
public class ConferenceController {

    private final ConferenceService conferenceService;

    ConferenceController(final ConferenceService conferenceService) {
        super();
        this.conferenceService = conferenceService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Conferences> getAllConferences() {
        log.info("GET all conferences");
        return new ResponseEntity<>(conferenceService.getAllConferences(), HttpStatus.OK);
    }

    @GetMapping(path = "/{conferenceId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Conference>  getConference(
            @Valid @PathVariable(value = "conferenceId") final String conferenceId) {

        log.info("GET conference by Id");
        return new ResponseEntity<>(conferenceService.getConference(conferenceId), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Conference> createConference(@Valid @RequestBody final Conference conference) {
        log.info("POST conference");
        return new ResponseEntity<>(conference, HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Conference> updateConference(@Valid @RequestBody final Conference conference) {
        log.info("PUT conference");
        return new ResponseEntity<>(conference, HttpStatus.OK);
    }

}
