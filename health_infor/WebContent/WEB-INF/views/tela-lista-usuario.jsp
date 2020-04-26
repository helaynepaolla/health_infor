<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@	taglib	uri="http://java.sun.com/jsp/jstl/core"	prefix="c"%>
<%@	taglib	uri="http://java.sun.com/jsp/jstl/fmt"	prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
<table>	
    <tr>
	    <th>Id</th>	
	    <th>Nome</th>	
	    <th>Email</th>
	    
    </tr>
	<c:forEach	items="${listacad}"	var="listacada">
        <tr>
	        <td>${listacada.cod}</td>
	        <td>${listacada.nome}</td>
	        <td>${listacada.email}</td>					
	    </tr>					
	</c:forEach>
</table>
<br/>
<br/>

</body>
</html>