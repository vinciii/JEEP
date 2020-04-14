package com.jee.prac.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int width = 100;
		int height = 40;
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics graphics = bufferedImage.getGraphics();
		graphics.setColor(Color.YELLOW);
		graphics.fillRect(0, 0, width - 1, height - 1);

		graphics.setColor(Color.RED);
		graphics.setFont(new Font("宋体", Font.BOLD, 20));
		String string = "0123456789";
		String msg = "";
		int x = 5;
		Random random = new Random();
		for (int i = 0; i < 4; i++) {
			int index = random.nextInt(10);
			String content = String.valueOf(string.charAt(index));
			msg += content;
		}

		graphics.drawString(msg, x, 28);

		graphics.dispose();

		ImageIO.write(bufferedImage, "jpg", response.getOutputStream());

		System.out.println(request.getContextPath());
		System.out.println(request.getRemoteAddr());
		System.out.println(request.getRequestURI());
		System.out.println(request.getRequestURL());
		System.out.println(request.getHeader("user-agent"));
		System.out.println(request.getHeader("referer"));
		Map<String, String[]> parameterMap = request.getParameterMap();

		for (String key : parameterMap.keySet()) {
			System.out.println(key);
			System.out.println(Arrays.toString(parameterMap.get(key)));
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		

		request.getRequestDispatcher("/code").forward(request, response);
		
		
		doGet(request, response);
	}

}
