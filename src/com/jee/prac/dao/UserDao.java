package com.jee.prac.dao;

import com.jee.prac.bean.User;
import com.jee.prac.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDao {

	public User getUserByUserNameAndPassWord(String username, String password) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataS());
		String sql = "select * from user where username =? and password = ?";
		User query = queryRunner.query(sql,new BeanHandler<User>(User.class),username, password);
		if (query!=null) {
			System.out.println(query.toString());
		}
		return query;
	}
	

	public int addUser(User user) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataS());
		String sql = "insert into user(username,password,sex,birthday,name,hobby) values(?,?,?,?,?,?)";
		return queryRunner.update(sql, user.getUsername(),user.getPassword(),user.getSex(),user.getBirthday(),user.getName(),user.getHobby()); 
	}

}
