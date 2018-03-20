package com.qa.banking.service;

import java.util.List;

import com.qa.banking.model.Account;
import com.qa.banking.model.Customer;

public interface AccountService {

	List<Account> list();

	Account create(Account account);

	Account get(Long id);

	Account update(Long id, Account account);

	Account delete(Long id);

}