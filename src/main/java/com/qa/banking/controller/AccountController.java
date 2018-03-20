package com.qa.banking.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qa.banking.model.Account;
import com.qa.banking.service.AccountService;

@RestController
@RequestMapping("api/v1")
public class AccountController {
	
	@Autowired
	private AccountService repository;
	
	
	@RequestMapping(value = "account", method = RequestMethod.GET)
	public List<Account> list() {
		return repository.list();
	}

	@RequestMapping(value = "account", method = RequestMethod.POST)
	public Account create(@RequestBody Account account) {
		return repository.create(account);
	}

	@RequestMapping(value = "account/{id}", method = RequestMethod.GET)
	public Account get(@PathVariable Long id) {
		return repository.get(id);
	}

	@RequestMapping(value = "account/{id}", method = RequestMethod.PUT)
	public Account update(@PathVariable Long id, @RequestBody Account movie) {
		Account existingAccount = repository.get(id);
		BeanUtils.copyProperties(movie, existingAccount);
		return repository.create(existingAccount);
	}

	@RequestMapping(value = "account/{id}", method = RequestMethod.DELETE)
	public Account delete(@PathVariable Long id) {
		Account existingAccount= repository.get(id);
		repository.delete(id);
		return existingAccount;
	}

}
