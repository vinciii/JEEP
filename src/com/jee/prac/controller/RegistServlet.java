package com.jee.prac.controller;

import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import com.jee.prac.bean.User;
import com.jee.prac.service.UserService;

public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ConvertUtils.register(new Converter() {
				
				public <T> T convert(Class<T> type, Object value) {
					String dateStr = (String)value;
					SimpleDateFormat spdt = new SimpleDateFormat("yyyyMMdd");
					try {
						Date date = (Date) spdt.parse(dateStr);
						return (T) date;
					} catch (ParseException e) {
						e.printStackTrace();
					}

					return null;
				}
			}, Date.class);
			request.setCharacterEncoding("utf-8");
			User user = new User();
			BeanUtils.populate(user, request.getParameterMap());
			UserService userService = new UserService();
			if (userService.regist(user) == 1) {
				request.setAttribute("msg", "成功");
				request.getRequestDispatcher("/msg").forward(request, response);
				
			} else {
				request.setAttribute("msg", "失败");
				request.getRequestDispatcher("/msg").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
