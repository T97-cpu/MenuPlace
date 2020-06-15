<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<style>
	*{
	font-family: sans-serif;
	text-align: center;
	}
	ul{
	list-style: none;
	}
	li{
	line-height: 2em;
	}
	li:hover{
	background-color: #ccc;
	}
	a{
	text-decoration: none;
	font-size: 1.5em;
	color: #000;
	}
</style>
</head>
<body>
	<h2>The Most Beautiful Places to Visit in Vietnam</h2>
	<ul><% 
	int length = (int) request.getAttribute("length");
	LinkedList<String> name = (LinkedList<String>) request.getAttribute("name");
	for(int i = 0; i < length; i++){
		out.println("<li><a href=\"\\MenuPlace\\place?name="+String.join("-",name.get(i).split(" "))+"\">"+name.get(i)+"</a></li>");
	}
	%></ul>
</body>
</html>