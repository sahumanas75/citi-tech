package com.cititech.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cititech.entity.Usermanagement;
import com.cititech.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping(value = "/authenticate")
	public String authenticateUser(@ModelAttribute("userDetails") Usermanagement usermanagement, ModelMap map,
			HttpSession session) {
		String userName = usermanagement.getUserName();
		String password = usermanagement.getPassword();

		userName = userName.trim();

		Usermanagement user = userService.userAuthenticate(userName, password);

		if (user != null) {
			session.setAttribute("userName", user.getUserName());
			map.put("msg", "Welcome " + userName);
			return "afterLogin";
		}

		else {
			map.put("username", userName);
			map.put("msg", "Invalid Username/Password..!!!");
			return "signin";
		}

	}

	@GetMapping(value = "/showSignupPage")
	public String showSignupPage() {
		return "signup";
	}

	@PostMapping(value = "/insertUserDetails")
	public String saveUserDetails(@ModelAttribute("userDetails") Usermanagement usermanagement, ModelMap map,
			HttpSession session) {
		String userName = usermanagement.getUserName();
		String emailId = usermanagement.getEmailId();

		userName = userName.trim();
		emailId = emailId.trim();

		usermanagement.setEmailId(emailId);

		boolean status = userService.checkUsernameExist(userName);
		boolean status1 = userService.checkEmailIdExist(emailId);

		if (status == true || status1 == true) {
			if (status == true) {
				map.put("msg", "Sorry, Username Already Exist..!!!");
				usermanagement.setUserName(userName);
				usermanagement.setEmailId(emailId);
				map.put("usermanagement", usermanagement);
				return "signup";
			} else if (status1 == true) {
				map.put("msg", "Sorry, Email-id Already Exist..!!!");
				usermanagement.setUserName(userName);
				usermanagement.setEmailId(emailId);
				map.put("usermanagement", usermanagement);
				return "signup";
			} else {
				map.put("msg", "Sorry, Something Went Wrong..!!!");
				usermanagement.setUserName(userName);
				usermanagement.setEmailId(emailId);
				map.put("usermanagement", usermanagement);
				return "signup";
			}
		} else {
			userService.createNewUSer(usermanagement);
			map.put("fmsg", "User Created Sucessfulyy...Now you can log in..!!");
			return "signin";
		}

	}

	@GetMapping(value = "/logOut")
	public String logOut(HttpSession session) {
		session.invalidate();
		session = null;
		return "signin";
	}

}
