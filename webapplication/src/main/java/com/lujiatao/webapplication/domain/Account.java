package com.lujiatao.webapplication.domain;

import java.io.Serializable;

public class Account implements Serializable {

	private static final long serialVersionUID = -5049602123660281999L;
	private String userName;
	private String password;

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

}
