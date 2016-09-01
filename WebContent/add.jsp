<%@page import="kr.co.saramin.emaillist.vo.EmailListVo"%>
<%@page import="kr.co.saramin.emaillist.dao.EmailListDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String firstName = request.getParameter("fn");
	String lastName = request.getParameter("ln");
	String email 	= request.getParameter("email");
	
	EmailListDao edo = new EmailListDao();
	EmailListVo  evo = new EmailListVo();
	evo.setFirstName(firstName);
	evo.setLastName(lastName);
	evo.setEmail(email);
	
	edo.insert(evo);
	
	response.sendRedirect("list.jsp");
%>    