package com.cititech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cititech.dao.UserDAO;
import com.cititech.entity.Usermanagement;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDao;

	@Override
	@Transactional
	public void createNewUSer(Usermanagement usermanagement) {
		userDao.createNewUSer(usermanagement);
	}

	@Override
	@Transactional
	public Usermanagement userAuthenticate(String userName, String password) {
		return userDao.userAuthenticate(userName, password);
	}

	@Override
	@Transactional
	public Usermanagement getUserDetails(String userName) {
		return userDao.getUserDetails(userName);
	}

	@Override
	@Transactional
	public boolean checkEmailIdExist(String emailId) {
		return userDao.checkEmailIdExist(emailId);
	}

	@Override
	@Transactional
	public boolean checkUsernameExist(String userName) {
		return userDao.checkUsernameExist(userName);
	}
}
