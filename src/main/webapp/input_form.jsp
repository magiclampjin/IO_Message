<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Input Form</title>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
</head>
<body>
	<form action="/insert.contacts" method="post">
    	<table border="1" align=center>
    		<tr>
    			<th>Input contacts</th>
    		</tr>
    		<tr>
    			<td><input type="text" name="name" placeholder="Input your name"></td>
    		</tr>
    		<tr>
    			<td><input type="text" name="contact" placeholder="Input your contact"></td>
    		</tr>
    		<tr>
    			<td style="text-align: center;">
    				<input type="submit" value="save">
    				<input type="button" id="back" value="back">
    			</td>
    		</tr>
    	</table>
    </form>
    
    <script>
    	$("#back").on("click", function(){
    		location.href="/index.jsp";
    	})
    </script>
</body>
</html>