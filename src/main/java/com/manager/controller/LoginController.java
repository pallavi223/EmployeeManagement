package com.manager.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.manager.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService service;
	

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView validate(HttpServletRequest request, HttpServletResponse response) {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		System.out.println("Service = " + service);

		boolean isValid = service.validateUser(username, password);
		
		
		ModelAndView mv = new ModelAndView();
		if(isValid) {
			mv.setViewName("employee-details");	//we don't need to mention extension because we have already mentioned it in config file
			mv.addObject("username", username);
		} else {
			mv.setViewName("error");
			mv.addObject("errorMessage", "Invalid username or password");
		}

		return mv;
	}
}
