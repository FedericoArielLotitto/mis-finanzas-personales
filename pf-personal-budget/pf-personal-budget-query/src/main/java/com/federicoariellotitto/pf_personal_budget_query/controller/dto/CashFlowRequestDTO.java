package com.federicoariellotitto.pf_personal_budget_query.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.Currency;

public record CashFlowRequestDTO(
        @JsonProperty("id")
        Long id,
        @JsonProperty("amount")
        @NotNull(message = "Amount must be present")
        @Positive(message = "Amount must be positive")
        BigDecimal amount,
        @JsonProperty("currency")
        @NotNull(message = "Currency must be present")
        Currency currency,
        @JsonProperty("description")
        String description,
        @JsonProperty("type")
        String type
) {
}
