package com.federicoariellotitto.pf_personal_budget_query.controller;

import com.federicoariellotitto.pf_personal_budget_query.controller.dto.CashFlowRequestDTO;
import com.federicoariellotitto.pf_personal_budget_query.controller.dto.CashFlowResponseDTO;
import com.federicoariellotitto.pf_personal_budget_query.domain.CashFlow;
import com.federicoariellotitto.pf_personal_budget_query.service.CashFlowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cash-flows")
@RequiredArgsConstructor
public class CashFlowController {
    private final CashFlowService cashFlowService;

    @GetMapping
    public ResponseEntity<List<CashFlowResponseDTO>> findAll() {
        var persistedCashFlows = cashFlowService.findAll();

        var body = persistedCashFlows.stream()
                .map(this::toCashFlowResponseDTO)
                .toList();

        return ResponseEntity.ok(body);
    }

    private CashFlow toCashFlow(CashFlowRequestDTO cashFlowRequestDTO) {
        var cashFlow = new CashFlow();
        cashFlow.setId(cashFlowRequestDTO.id());
        cashFlow.setCurrency(cashFlowRequestDTO.currency());
        cashFlow.setDescription(cashFlowRequestDTO.description());
        cashFlow.setAmount(cashFlowRequestDTO.amount());
        cashFlow.setCreationDateTime(LocalDateTime.now());
        //cashFlow.setType(Type.valueOf(cashFlowRequestDTO.type()));
        cashFlow.setType(cashFlowRequestDTO.type());
        return cashFlow;
    }

    private CashFlowResponseDTO toCashFlowResponseDTO(CashFlow cashFlow) {
        return CashFlowResponseDTO.builder()
                .id(cashFlow.getId())
                .amount(cashFlow.getAmount())
                .description(cashFlow.getDescription())
                .currency(cashFlow.getCurrency())
                .creationDateTime(cashFlow.getCreationDateTime())
                .type(cashFlow.getType())
                .build();
    }
}
