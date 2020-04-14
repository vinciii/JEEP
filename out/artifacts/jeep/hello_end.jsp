<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>end页面</title>

</head>
<body>
username: <%= request.getParameter("username")%>


password: <%= request.getParameter("password")%>
</body>
</html>