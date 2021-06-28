package com.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.manager.dao.LoginDao;

@Service
@Component
public class LoginService {

	
	@Autowired
	private LoginDao loginDao;
	
	public boolean validateUser(String username, String password) {
		boolean isValid = loginDao.validate(username, password);
		return isValid;
	}
}
