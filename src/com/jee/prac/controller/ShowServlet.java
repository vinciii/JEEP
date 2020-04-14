package com.jee.prac.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext servletContext = getServletContext();
		Object attribute = servletContext.getAttribute("loginCount");
		resp.getWriter().print(attribute + "get");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext servletContext = getServletContext();
		Object attribute = servletContext.getAttribute("loginCount");
		resp.getWriter().print(attribute + "post");
	}

}
