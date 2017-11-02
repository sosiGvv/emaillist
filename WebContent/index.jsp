<%@page import="kr.co.saramin.emaillist.vo.EmailListVo"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.saramin.emaillist.dao.EmailListDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	EmailListDao dao = new EmailListDao();
	List<EmailListVo> list = dao.getList();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		for (EmailListVo vo : list) {
	%>
	<table border="1" cellpadding="5" cellspacing="2">
		<tr>
			<td align=right>First name: </td>
			<td><%= vo.getFirstName() %></td>
		</tr>
		<tr>
			<td align="right" width="110">Last name: </td>
			<td><%= vo.getLastName() %></td>
		</tr>
		<tr>
			<td align=right>Email address: </td>
			<td><%= vo.getEmail() %></td>
		</tr>
	</table>
	<%
		}
	%>
</body>
</html>