package com.lujiatao.webapplication;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	public void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {
		new DefaultRedirectStrategy().sendRedirect(request, response, "/index");
	}

}
