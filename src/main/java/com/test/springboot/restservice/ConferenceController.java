package com.test.springboot.restservice;

import com.test.springboot.restservice.dto.Conference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.ok;

// TODO: H2 database
// TODO: Docker
// TODO: Heroku

@RestController
@Slf4j
@RequestMapping(path = "/conference")
public class ConferenceController {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ConferenceController.class);

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
            @Valid @PathVariable(value = "conferenceId") final long conferenceId) {
        logger.info("GET conference by Id" + conferenceId);

        if(conferenceId < 1) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ok(conferenceService.getConference(conferenceId));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> createConference(@Valid @RequestBody final Conference conference) {
        logger.info("POST conference");
        return ok(conference);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> updateConference(@Valid @RequestBody final Conference conference) {
        logger.info("PUT conference");
        return ok(conference);
    }
}
