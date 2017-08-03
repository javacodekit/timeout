<%@ page language="java" contentType="text/x-json; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.opensymphony.xwork2.*,com.opensymphony.xwork2.util.*"%>
<%
ValueStack stack = ActionContext.getContext().getValueStack();
String ou = (String) stack.getContext().get("jsonval");
out.println(ou);
%>