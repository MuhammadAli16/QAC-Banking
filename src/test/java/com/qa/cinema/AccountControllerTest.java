package com.qa.cinema;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.qa.banking.controller.AccountController;
import com.qa.banking.model.Account;
import com.qa.banking.model.Customer;
import com.qa.banking.service.AccountService;

public class AccountControllerTest {

	@InjectMocks
	private AccountController controller;

	@Mock
	private AccountService service;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testEndpointGet() {
		Account mockMovie = new Account();
		mockMovie.setId(1l);
		when(service.get(1L)).thenReturn(mockMovie);
		Account movie = controller.get(1L);
		verify(service).get(1l);
		assertThat(movie.getId(), is(1l));
	}
}
