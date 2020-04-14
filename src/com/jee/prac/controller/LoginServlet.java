package com.jee.prac.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jee.prac.bean.User;
import com.jee.prac.service.UserService;

public class LoginServlet extends HttpServlet {
	private  ServletContext lContext = null;
	@Override
	public void init() throws ServletException {
		super.init();
		lContext = getServletContext();
		lContext.setAttribute("loginCount", 0);
		ServletConfig servletConfig = getServletConfig();

	}
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");

		resp.addHeader("content-type", "text/html;charset=UTF-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");



		UserService service = new UserService();
		String realPath = lContext.getRealPath("/");
		try {
			User user = service.login(username, password);
			int attribute = (Integer) lContext.getAttribute("loginCount");
			attribute++;
			lContext.setAttribute("loginCount", attribute);
			if (user != null) {
				System.out.println("LoginServlet    " + user.toString());
				System.out.println(" LOGIN SUCC 登录成功!!<br><br> " + user.toString());
				resp.getWriter().println("  LOGIN SUCC 登录成功!!<br>");
				resp.getWriter().println(lContext.getAttribute("loginCount") +"<br>");
				resp.getWriter().println(realPath +"/1.txt<br>");
				resp.getWriter().println(lContext.getMimeType("1.png")  + "<br>");
				resp.addHeader("refresh", "30;url=/JEEP/show");

			} else {
				resp.getWriter().println("  LOGIN FAILD  登录失败!!");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);

	}

}
