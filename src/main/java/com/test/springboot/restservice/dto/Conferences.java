package com.test.springboot.restservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.test.springboot.restservice.dto.Conference;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Conferences {

    @NotNull
    List<Conference> conferences;
}
