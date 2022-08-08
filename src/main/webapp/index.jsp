<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index Page</title>
</head>
<body>
	Hello <%=new Date() %>
	<ol>
		<li>
			Session 09 Lotto Lab <br>
			<a href="/spring.mvc/mvc/lotto/">/spring.mvc/mvc/lotto/</a>
		</li>
		<li>
			Session 10 Product Lab <br>
			<a href="/spring.mvc/mvc/product/">/spring.mvc/mvc/product/</a>
		</li>
		<li>
			Session 11 User Lab <br>
			<a href="/spring.mvc/mvc/user/">/spring.mvc/mvc/user/</a>
		</li>
		<li>
			Session 12  Person Lab <br>
			<a href="${ pageContext.request.contextPath }/mvc/person/">/spring.mvc/mvc/person/</a>
		</li>
	</ol>
</body>
</html>