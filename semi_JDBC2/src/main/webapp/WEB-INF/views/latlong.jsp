<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h1>제발 들어와라</h1>


<table border="1">
		<tr>
			<th>위도</th>
			<th>경도</th>


			
		</tr>
		<tr>
		 <c:forEach items = "${google_map}" var = "dto"> 
			<%-- <td><a href = "google_map_input?bYear=${dto.bYear}">${dto.bYear}</td> --%>
			<td><c:out value="${dto.getLatitude()}" /></td>
			<td><c:out value="${dto.getLongitude()}" /></td>
		<%-- 	<td>${dto.Latitude}</td> --%>
	

					
		 </c:forEach>
		</tr>
		

		
		
	</table>

</body>
</html>