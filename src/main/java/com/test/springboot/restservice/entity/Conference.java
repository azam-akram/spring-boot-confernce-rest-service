package com.test.springboot.restservice.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Conference {

    @Id
    @GeneratedValue
    private long conferenceId;

    @NotBlank
    private String title;

    @NotBlank
    private String location;

    /*@NotNull
    @OneToMany(targetEntity = Participant.class, fetch= FetchType.EAGER)
    private List<Participant> participants;*/
}
