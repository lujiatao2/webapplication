package com.lujiatao.webapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.lujiatao.webapplication.service.AccountService;

@Configuration
public class CertificationAndAuthorization extends WebSecurityConfigurerAdapter {

	@Autowired
	SuccessHandler successHandler;
	@Autowired
	AccountService accountService;

	// 认证
	@Autowired
	public void certificate(AuthenticationManagerBuilder builder) throws Exception {
		builder.userDetailsService(accountService).passwordEncoder(new BCryptPasswordEncoder());
	}

	// 授权
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/login", "/index-demo", "/openIPhone6S", "/openMotoZ").permitAll()
				.anyRequest().authenticated().and().formLogin().loginPage("/login").successHandler(successHandler)
				.usernameParameter("username").passwordParameter("password").and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");
	}

}
