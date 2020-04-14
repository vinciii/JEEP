package com.jee.prac.controller;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LifeServlet implements Servlet {

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");
//		"都收到"
	}

	public ServletConfig getServletConfig() {
		System.out.println("getServletConfig");
		return null;
	}

	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("service");
		
	}

	public String getServletInfo() {
		System.out.println("getServletInfo");
		return null;
	}

	public void destroy() {
		System.out.println("destroy");
		
	}

}
