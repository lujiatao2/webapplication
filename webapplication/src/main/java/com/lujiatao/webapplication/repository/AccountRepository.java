package com.lujiatao.webapplication.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.lujiatao.webapplication.domain.Account;

@Repository
public class AccountRepository {

	private static Map<String, Account> accounts = new HashMap<>();

	static {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Account zhangsan = new Account();
		zhangsan.setUserName("zhangsan");
		zhangsan.setPassword(encoder.encode("zhangsan123456"));
		accounts.put(zhangsan.getUserName(), zhangsan);
		Account lisi = new Account();
		lisi.setUserName("lisi");
		lisi.setPassword(encoder.encode("lisi123456"));
		accounts.put(lisi.getUserName(), lisi);
	}

	public Account getAccount(String userName) {
		return accounts.get(userName);
	}

}
