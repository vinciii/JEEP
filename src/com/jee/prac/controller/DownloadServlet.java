package com.jee.prac.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		ServletContext servletContext = this.getServletContext();
		
		
		String filename = request.getParameter("filename");
		String mimeType = servletContext.getMimeType(filename);
		response.setContentType(mimeType);

		response.setHeader("content-disposition", "attachment;filename=" + filename);

		InputStream is = servletContext.getResourceAsStream("download/1.txt");
		ServletOutputStream outputStream = response.getOutputStream();

		int len = -1;
		byte[] n = new byte[1024];
		if (is==null) {
			System.out.println("null obj");	
			return;
		}
		
		while ((len = is.read(n)) != -1) {
			outputStream.write(n);
		}
		outputStream.close();
		is.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doGet(request, response);
	}

}
