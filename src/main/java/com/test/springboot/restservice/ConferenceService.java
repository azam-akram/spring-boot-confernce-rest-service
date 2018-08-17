package com.test.springboot.restservice;

import com.test.springboot.restservice.dto.Conference;
import com.test.springboot.restservice.dto.Conferences;
import com.test.springboot.restservice.dto.Participant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ConferenceService {

    public Conferences getAllConferences() {

        List<Conference> conferencesList = new ArrayList<>();
        List<Participant> participants = new ArrayList<>();

        Participant participant1 = Participant.builder()
                .name("BOB")
                .email("bob@test.com")
                .build();
        participants.add(participant1);
        Participant participant2 = Participant.builder()
                .name("Alice")
                .email("alice@test.com")
                .build();
        participants.add(participant2);

        Conference conference1 = Conference.builder()
                .conferenceId(1)
                .title("IETF")
                .location("Stockholm")
                .eventDateTime("2018-12-01")
                .participants(participants)
                .build();

        Conference conference2 = Conference.builder()
                .conferenceId(2)
                .title("JFokus")
                .location("London")
                .eventDateTime("2018-11-01")
                .participants(participants)
                .build();

        conferencesList.add(conference1);
        conferencesList.add(conference2);

        return Conferences.builder()
                .conferences(conferencesList)
                .build();
    }

    public Conference getConference(long conferenceId) {
        List<Participant> participantList = new ArrayList<>();
        Participant aParticipant = Participant.builder().name("Azam").email("azam@test.com").build();
        participantList.add(aParticipant);

        Conference conference = Conference.builder()
                .conferenceId(conferenceId)
                .title("IETF")
                .location("Stockholm")
                .eventDateTime("2018-12-01")
                .participants(participantList)
                .build();

        return conference;
    }
}
