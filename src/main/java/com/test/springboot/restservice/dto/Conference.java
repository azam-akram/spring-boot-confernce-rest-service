package com.test.springboot.restservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Conference {

    @NotNull
    private long conferenceId;

    @NotBlank
    private String title;

    @NotBlank
    private String location;

    @NotBlank
    private String eventDateTime;

    @NotNull
    private List<Participant> participants;
}
