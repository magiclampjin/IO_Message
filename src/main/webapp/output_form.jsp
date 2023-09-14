<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact List</title>
</head>
<body>

	<c:forEach var="i" items="${list }">	
				${i.seq } : ${i.name } : ${i.contact }<br>		
	</c:forEach>
	
</body>
</html>