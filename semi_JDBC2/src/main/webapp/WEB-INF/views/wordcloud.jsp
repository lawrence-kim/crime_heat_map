<%@page import="com.springlec.semi_JDBC.dao.BDao"%>
<%@page import="com.springlec.semi_JDBCRjsp.RjspJava"%>
<%-- <%@page import="org.apache.tomcat.util.codec.binary.Base64" %> --%>
<%@page import= "org.apache.commons.codec.binary.Base64" %>
    
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



	<h1>R과 JSP 연결</h1>
	<%
	 	RjspJava rj = new RjspJava();  // 위에 <%@page import="com.jsplec.Rjsp.RjspJava" 생김
	%>
	
	<h3> 1~9 까지의 합계 구하기</h3>
	
	<%
	 	out.println(rj.getSum());
	%>
	
	
	<h3> 1~9 까지의 평균 구하기</h3>
	
	<%
		out.println(rj.getMean());
	%>
	
	
	
	<h3> head(iris)</h3>
	
	<%
		int cols = rj.getIrisCols();
		int rows = rj.getIrisRows();
		String[][] s = rj.getIris();
		String[] rHead = rj.getIrisHeader();
	%>
	<table border="1">
		<tr>
		<% for(int i =0; i < cols; i++){ %>
			<td><%out.println(rHead[i]); %></td>
		<%} %>
		</tr>
		
		
		<% for(int i=0; i < rows; i++ ){%>
		
		<tr>
			<% for(int j=0; j < cols; j++){ %>
				<td><% out.println(s[j][i]); %></td>
			<% } %>	
		</tr>	
		
		<% } %>	
	</table>
		
		
	<h3>plot(iris$Sepal.Length)</h3>
	<%
		String dataimage = Base64.encodeBase64String(rj.getPlot()); //없다고 나와서 강제적으로 임포트 해야함 
											//<%@page import="com.sun.org.apache.xerces.internal.impl.dv.util.Base64"% ,  이거 지우고
											// <%@page import="org.apache.tomcat.util.codec.binary.Base64" % 추가함
											
		
	%>
	<img src = "data:image/png;base64,<%=dataimage %>"> 

</body>
</html>