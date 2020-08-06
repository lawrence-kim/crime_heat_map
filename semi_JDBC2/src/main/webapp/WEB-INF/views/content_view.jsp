<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<form action = "modify" method = "post">
			<tr>
				<td>번호</td>
				<td><input type="text" name ="bId" value="${content_view.bId}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name ="bName" value="${content_view.bName}" ></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name ="bTel" value="${content_view.bTel}" ></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name ="bAddress" value="${content_view.bAddress}" ></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name ="bEmail" value="${content_view.bEmail}" ></td>
			</tr>
			<tr>
				<td>관계</td>
				<td><input type="text" name ="bRelation" value="${content_view.bRelation}" ></td>
			</tr>
			


			<tr>
				<td colspan="2"><input type="submit" value="수정">&nbsp;&nbsp;<a href="list">목록보기</a>&nbsp;&nbsp;<a href = "delete?bId=${content_view.bId}">삭제</a>&nbsp;&nbsp;</td>
			</tr>
			
		</form>
	</table>

</body>
</html>