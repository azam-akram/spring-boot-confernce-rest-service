package com.test.springboot.restservice.repository;

import com.test.springboot.restservice.entity.Participant;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ParticipantRepository extends CrudRepository<Participant, Integer> {

    Optional<Participant> findByParticipantId(Integer participantId);

}
