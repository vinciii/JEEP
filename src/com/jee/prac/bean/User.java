package com.jee.prac.bean;

import java.util.Date;

public class User {

		String username;
		String password;
		String sex;
		Date birthday ;
		String hobby;
		String name;
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public Date getBirthday() {
			return birthday;
		}
		public void setBirthday(Date date) {
			
			this.birthday = date;
		}
		public String getHobby() {
			return hobby;
		}
		public void setHobby(String hobby) {
			this.hobby = hobby;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		@Override
		public String toString() {
			return "User [username=" + username + ", password=" + password + ", sex=" + sex + ", birthday=" + birthday
					+ ", hobby=" + hobby + ", name=" + name + "]";
		}
		
		
		
	 

}
