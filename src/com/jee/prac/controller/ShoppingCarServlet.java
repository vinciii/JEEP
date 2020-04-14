package com.jee.prac.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCarServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();

        String name = req.getParameter("name");
        String s = new String(name.getBytes("iso-8859-1"), "utf-8");

        Map<String, Integer> cat = (Map<String, Integer>) req.getSession().getAttribute("cart");

        Integer integer = null;
        if (cat == null) {
            //第一次`创购物车
            cat = new HashMap<>();
            req.getSession().setAttribute("cart", cat);
            integer = 1;
        } else {
            integer = cat.get(name);
            integer = integer == null ? 1 : ++integer;
        }
        cat.put(name, integer);
        writer.println("已将 " +name + " 放入购物车 "  +  integer);
        writer.println("继续购物 " +  integer);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
