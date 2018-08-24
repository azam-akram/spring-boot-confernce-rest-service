package com.test.springboot.restservice.repository;

import com.test.springboot.restservice.entity.Conference;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ConferenceRepository extends CrudRepository<Conference, Integer> {

    Optional<Conference> findByConferenceId(Long conferenceId);

    List<Conference> findAll();

}
