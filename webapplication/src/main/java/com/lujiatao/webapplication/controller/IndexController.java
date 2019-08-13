package com.lujiatao.webapplication.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping({ "/", "/index" })
	public String index(Model model) {
		String user = SecurityContextHolder.getContext().getAuthentication().getName();
		model.addAttribute("user", user);
		return "index";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/index-demo")
	public String indexDemo() {
		return "index-demo";
	}

	@GetMapping("/openIPhone6S")
	public String openIPhone6S() {
		return "open-iphone-6s";
	}

	@GetMapping("/openMotoZ")
	public String openMotoZ() {
		return "open-moto-z";
	}

}
