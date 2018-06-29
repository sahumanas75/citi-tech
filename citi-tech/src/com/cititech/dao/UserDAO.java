package com.cititech.dao;

import com.cititech.entity.Usermanagement;

public interface UserDAO {
	boolean checkEmailIdExist(String emailId);

	void createNewUSer(Usermanagement usermanagement);

	Usermanagement userAuthenticate(String userName, String password);

	Usermanagement getUserDetails(String userName);

	boolean checkUsernameExist(String userName);

}
