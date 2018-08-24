package com.test.springboot.restservice.service;

import com.test.springboot.restservice.entity.Conference;
import com.test.springboot.restservice.entity.Conferences;
import com.test.springboot.restservice.repository.ConferenceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ConferenceService {

    @Autowired
    private final ConferenceRepository conferenceRepository;

    public ConferenceService(ConferenceRepository conferenceRepository) {
        this.conferenceRepository = conferenceRepository;
    }

    public Conferences getAllConferences() {
        List<Conference> conferencesList = conferenceRepository.findAll();
        return Conferences.builder()
                .conferences(conferencesList)
                .build();
    }

    public Optional<Conference> getConference(long conferenceId) {
        return conferenceRepository.findByConferenceId(conferenceId);
    }

    public Conference createConference(Conference conference) {
        return conferenceRepository.save(conference);
    }

    public Conference updateConference(Conference conference) {
        // TODO: parse conference is and update the conference
        return conferenceRepository.save(conference);
    }
}
