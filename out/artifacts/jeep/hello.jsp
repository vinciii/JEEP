<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>JSP 入门页面</title>

</head>
<body>
<%! String username;%>
<% username = request.getParameter("username");%>
<jsp:forward page="/hello_end.jsp">
    <jsp:param name="username" value="<%=username%>"/>
    <jsp:param name="password" value="password"/>
</jsp:forward>
</body>
</html>