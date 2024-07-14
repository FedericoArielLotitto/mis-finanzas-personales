package com.federicoariellotitto.pf_personal_budget_query.repository;


import com.federicoariellotitto.pf_personal_budget_query.domain.CashFlow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CashFlowRepository extends JpaRepository<CashFlow, Long> {
}
