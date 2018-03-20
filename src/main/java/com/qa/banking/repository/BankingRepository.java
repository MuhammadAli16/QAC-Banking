package com.qa.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.banking.model.Account;

public interface BankingRepository extends JpaRepository<Account, Long> {

}
