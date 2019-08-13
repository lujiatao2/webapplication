package com.lujiatao.webapplication.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lujiatao.webapplication.domain.Account;
import com.lujiatao.webapplication.repository.AccountRepository;

@Service
public class AccountService implements UserDetailsService {

	@Autowired
	private AccountRepository accountRepository;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountRepository.getAccount(username);
		if (account == null) {
			throw new UsernameNotFoundException("帐户不存在！");
		}
		return new User(account.getUserName(), account.getPassword(), new ArrayList<GrantedAuthority>());
	}

}
