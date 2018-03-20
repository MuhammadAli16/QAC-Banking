package com.qa.banking.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.qa.banking.model.Account;
import com.qa.banking.repository.BankingRepository;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private BankingRepository repository;
	
	public List<Account> list() {
		return repository.findAll();
	}
	
	public Account create(@RequestBody Account account) {
		return repository.saveAndFlush(account);
	}

	public Account get(@PathVariable Long id) {
		return repository.findOne(id);
	}

	public Account update(@PathVariable Long id, @RequestBody Account movie) {
		Account existingAccount = repository.findOne(id);
		BeanUtils.copyProperties(movie, existingAccount);
		return repository.saveAndFlush(existingAccount);
	}
	
	public Account delete(@PathVariable Long id) {
		Account existingAccount = repository.findOne(id);
		repository.delete(existingAccount);
		return existingAccount;
	}

}
