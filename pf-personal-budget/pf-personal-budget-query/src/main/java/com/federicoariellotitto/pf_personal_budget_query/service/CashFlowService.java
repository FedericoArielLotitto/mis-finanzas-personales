package com.federicoariellotitto.pf_personal_budget_query.service;

import com.federicoariellotitto.pf_personal_budget_query.domain.CashFlow;
import com.federicoariellotitto.pf_personal_budget_query.exception.ResourceNotFoundException;
import com.federicoariellotitto.pf_personal_budget_query.repository.CashFlowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CashFlowService {

    private final CashFlowRepository cashFlowRepository;

    public List<CashFlow> findAll() {
        return cashFlowRepository.findAll();
    }

    private void validateNotNullCreationDateTime(CashFlow cashFlow) {
        Assert.notNull(cashFlow.getCreationDateTime(), "CashFlow creationDateTime must be not null");
    }

    private void validatePositiveAmount(CashFlow cashFlow) {
        Assert.isTrue(null != cashFlow.getAmount() && cashFlow.getAmount().compareTo(BigDecimal.ZERO) > 0, "CashFlow amount must be positive");
    }

    private void validateCashFlowDoesNotExist(CashFlow cashFlow) {
        Assert.isNull(cashFlow.getId(), "CashFlow id must be null");
    }

    private void validatePresentCurrency(CashFlow cashFlow) {
        Assert.notNull(cashFlow.getCurrency(), "CashFlow currency must be present");
    }

    private void validateCashFlowExist(Long id) {
        if (!cashFlowRepository.existsById(id)) {
            throw new ResourceNotFoundException("CashFlow", "id", id.toString());
        }
        Assert.isTrue(cashFlowRepository.findById(id).isPresent(), "CashFlow does not exist");
    }

    private void validateCashFlowId(Long id) {
        Assert.notNull(id, "CashFlow id must not be null");
    }

    public void delete(Long id) {
        validateCashFlowExist(id);
        cashFlowRepository.deleteById(id);
    }
}
