package com.federicoariellotitto.pf_personal_budget_query.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

public record ErrorResponseDTO(
        @JsonProperty("api_path")
        String apiPath,
        @JsonProperty("error_code")
        HttpStatus errorCode,
        @JsonProperty("error_message")
        String errorMessage,
        @JsonProperty("error_time")
        LocalDateTime errorTime
) {
}
