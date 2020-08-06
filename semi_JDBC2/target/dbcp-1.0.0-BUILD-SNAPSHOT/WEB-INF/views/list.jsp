<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC 게시판</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>주소</th>
			<th>이메일</th>
			<th>관계</th>

			
		</tr>
		<c:forEach items = "${list}" var = "dto">
		<tr>
			<td><a href = "content_view?bId=${dto.bId}">${dto.bId}</td>
			<td>${dto.bName}</td>
			<td>${dto.bTel}</td>
			<td>${dto.bAddress}</td>
			<td>${dto.bEmail}</td>
			<td>${dto.bRelation}</td>			

					
		</tr>
		
		</c:forEach>
		<tr>
			<td colspan="6"><a href = "write_view">글 작성</a></td>
		</tr>
		
		
	</table>

</body>
</html>