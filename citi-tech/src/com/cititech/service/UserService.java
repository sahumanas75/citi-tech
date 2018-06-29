package com.cititech.service;

import com.cititech.entity.Usermanagement;

public interface UserService {

	void createNewUSer(Usermanagement usermanagement);

	Usermanagement userAuthenticate(String userName, String password);

	boolean checkEmailIdExist(String emailId);

	Usermanagement getUserDetails(String userName);

	boolean checkUsernameExist(String userName);

}
