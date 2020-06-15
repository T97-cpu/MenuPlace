<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${name}</title>
<style>
	*{
	font-family: sans-serif;
	text-align: center;
	}
</style>
</head>
<body>
	<h2>${name}</h2>
	<iframe src="${url}" width="100%" height="400" aria-hidden="false" tabindex="0"></iframe>
	<p>${description}</p>
</body>
</html>