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
      <form action = "write" method="post">
         <tr>
            <td>이름</td>
            <td><input type="text" name="bName" size="50"></td>
         </tr>
         <tr>
            <td>전화번호</td>
            <td><input type="text" name="bTel" size="50"></td>
         </tr>
         <tr>
            <td>주소</td>
            <td><input type="text" name="bAddress" size="50"></td>
         </tr>
         <tr>
            <td>이메일</td>
            <td><input type="text" name="bEmail" size="50"></td>
         </tr>         
         <tr>
            <td>관계</td>
            <td><input type="text" name="bRelation" size="50"></td>
         </tr>         
         
         <tr>
            <td colspan="2"><input type="submit" value="입력"> &nbsp;&nbsp; <a href="list">목록보기</a></td>
         </tr>
      </form>
   </table>

</body>
</html>