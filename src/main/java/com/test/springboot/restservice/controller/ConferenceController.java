package com.test.springboot.restservice.controller;

import com.test.springboot.restservice.entity.Conference;
import com.test.springboot.restservice.service.ConferenceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.ok;

// TODO: Docker

@RestController
@Slf4j
@RequestMapping(path = "/conference")
public class ConferenceController {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ConferenceController.class);


    @Autowired
    private final ConferenceService conferenceService;

    ConferenceController(final ConferenceService conferenceService) {
        super();
        this.conferenceService = conferenceService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getAllConferences() {
        logger.info("GET all conferences");
        return ok(conferenceService.getAllConferences());
    }

    @GetMapping(path = "/{conferenceId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?>  getConference(
            @Valid @PathVariable(value = "conferenceId") final Long conferenceId) {
        logger.info("GET conference by Id" + conferenceId);
        if(conferenceId < 1) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Optional<Conference> conference = conferenceService.getConference(conferenceId);
        if(conference.isPresent()) {
            return ok(conference.get());
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> createConference(@Valid @RequestBody final Conference conference) {
        logger.info("POST conference");
        Conference con = conferenceService.createConference(conference);
        return ok(con);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> updateConference(@Valid @RequestBody final Conference conference) {
        logger.info("PUT conference");
        Conference con = conferenceService.updateConference(conference);
        return ok(con);
    }
}
