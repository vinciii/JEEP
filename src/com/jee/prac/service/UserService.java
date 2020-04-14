package com.jee.prac.service;

import java.sql.SQLException;

import com.jee.prac.bean.User;
import com.jee.prac.dao.UserDao;

public class UserService {

	public User login(String usernme, String password) throws SQLException {
		UserDao dao = new UserDao();
		User user = dao.getUserByUserNameAndPassWord(usernme, password);
		return user;
	}

	public int regist(User user) throws SQLException {
		UserDao dao = new UserDao();
		int userResult = dao.addUser(user);
		return userResult;
	}

}
