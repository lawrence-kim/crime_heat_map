<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
















<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="UTF-8" />
      <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
      <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
      <meta name="description" content="Simple Effects for Drop-Down Lists" />
      <meta name="keywords" content="drop-down, select, jquery, plugin, fallback, transition, transform, 3d, css3" />
      <meta name="author" content="Codrops" />
      <link rel="shortcut icon" href="../favicon.ico"> 
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources//css/style1.css" />
      <script src="js/modernizr.custom.63321.js"></script>
      
 	 <meta name="Generator" content="EditPlus®">
 	 <meta name="Author" content="">
  	 <meta name="Keywords" content="">
	 <meta name="Description" content="">


      
      
      
      
    <style>
    
	#map {
        height: 100%;
        width : 50%;
      }
      /* Optional: Makes the sample page fill the window. */
      html, body {
        height: 80%;
        margin: 0;
        padding: 0;
      }



    </style>
  </head>
  <body>
  	
   <div class="container">   
         <!-- Codrops top bar -->
         <div class="codrops-top clearfix">
            <a href="http://tympanus.net/Development/Calendario/">

            </a>
            <span class="right">

               <a href="http://tympanus.net/codrops/?p=12452">

               </a>
            </span>
         </div><!--/ Codrops top bar -->         
         <header class="clearfix">         
            <h1><a href="http://192.168.0.52:8080/Boot_Test/index">Map<span>in Vancouver</a></span><a href="http://192.168.0.52:8080/Boot_Test/index"></h1>
            <nav class="codrops-demos">
               <a class="current-demo" href="http://192.168.0.9:8080/vancouvercrime/machineinput">Criminal Prediction</a>
               <a href="http://192.168.0.52:8080/Boot_Test/Vancouver_info">For Vancouver</a>
               <a href="http://192.168.0.9:8080/vancouvercrime/graph">Find Crime by Region Map</a>
               <a href="http://192.168.0.116:8080/semi_JDBC/google_map">A Crime Map</a>
               <a href="WordCloud">Word Cloud</a>
               
               <!-- <a class="current-demo" href="http://192.168.0.52:8080/Boot_Test/index">Home</a> -->

            </nav>            
         </header>

		<section class="main clearfix">
            <div class="left-box">
            
            </div>
		</section>

	</div>
    



<div style="float: left; width: 30%">

   <h2>Input Parameters</h2>
      <form action = "google_map_input" method="get" >
	   <table border="1">
         <tr>
            <td>year</td>
            <td><select name="YEAR">
	            <option value="IS NOT NULL" selected >Choose here</option>
                <option value= "=2003">2003</option>
                <option value= "=2004">2004</option>
                <option value= "=2005">2005</option>
                <option value= "=2006">2006</option>
                <option value= "=2007">2007</option>
                <option value= "=2008">2008</option>
                <option value= "=2009">2009</option>
                <option value= "=2010">2010</option>
                <option value= "=2011">2011</option>
                <option value= "=2012">2012</option>
                <option value= "=2013">2013</option>
                <option value= "=2014">2014</option>
                <option value= "=2015">2015</option>
                <option value= "=2016">2016</option>
                <option value= "=2017">2017</option>
                <option value= "=2018">2018</option>
                <option value= "=2019">2019</option> 
				<!--             <td><input type="text" name="YEAR" size="50"></td> -->            
            </select></td>

         </tr>     

 		<tr>
			<td>month</td>
			<td><select name="MONTH">
	            <option value="IS NOT NULL" selected >Choose here</option>
                <option value= "=1">January</option>
                <option value= "=2">February</option>
                <option value= "=3">March</option>
                <option value= "=4">April</option>
                <option value= "=5">May</option>
                <option value= "=6">June</option>
                <option value= "=7">July</option>
                <option value= "=8">August</option>
                <option value= "=9">September</option>
                <option value= "=10">October</option>
                <option value= "=11">November</option>
                <option value= "=12">December</option>
		</tr>


		<tr>
			<td>hour</td>
			<td><select name = "HOUR" >
	            <option value="IS NOT NULL" selected >Choose here</option>
				<option value = "=0"> 0 </option>
				<option value = "=1"> 1 </option>
				<option value = "=2"> 2 </option>
				<option value = "=3"> 3 </option>
				<option value = "=4"> 4 </option>
				<option value = "=5"> 5 </option>
				<option value = "=6"> 6 </option>
				<option value = "=7"> 7 </option>
				<option value = "=8"> 8 </option>
				<option value = "=9"> 9 </option>
				<option value = "=10"> 10 </option>
				<option value = "=11"> 11 </option>
				<option value = "=12"> 12 </option>
				<option value = "=13"> 13 </option>
				<option value = "=14"> 14 </option>
				<option value = "=15"> 15 </option>
				<option value = "=16"> 16 </option>
				<option value = "=17"> 17 </option>
				<option value = "=18"> 18 </option>
				<option value = "=19"> 19 </option>
				<option value = "=20"> 20 </option>
				<option value = "=21"> 21 </option>
				<option value = "=22"> 22 </option>
				<option value = "=23"> 23 </option>
				
	


			
				

			</select>
		</td></tr>




	




		<tr>
			<td>neighbourhood</td>
			<td><select name = "NEIGHBOURHOOD">
	            <option value="IS NOT NULL" selected >Choose here</option>
               <option value= "='Central Business District'">Central Business District</option>
               <option value= "='Shaughnessy'">Shaughnessy</option>
               <option value= "='Fairview'">Fairview</option>
               <option value= "='Kitsilano'">Kitsilano</option>
               <option value= "='Grandview-Woodland'">Grandview-Woodland</option>
               <option value= "='nearby 312 Main Street'">nearby 312 Main Street</option>
               <option value= "='Victoria-Fraserview'">Victoria-Fraserview</option>
               <option value= "='Sunset'">Sunset</option>
               <option value= "='Killarney'">Killarney</option>
               <option value= "='Dunbar-Southlands'">Dunbar-Southlands</option>
               <option value= "='West End'">West End</option>
               <option value= "='Marpole'">Marpole</option>
               <option value= "='Hastings-Sunrise'">Hastings-Sunrise</option>
               <option value= "='Riley Park'">Riley Park</option>
               <option value= "='Kensington-Cedar Cottage'">Kensington-Cedar Cottage</option>
               <option value= "='Mount Pleasant'">Mount Pleasant</option>
               <option value= "='Renfrew-Collingwood'">Renfrew-Collingwood</option>
               <option value= "='Strathcona'">Strathcona</option>
               <option value= "='Kerrisdale'">Kerrisdale</option>
               <option value= "='South Cambie'">South Cambie</option>
               <option value= "='Arbutus Ridge'">Arbutus Ridge</option>
               <option value= "='Oakridge'">Oakridge</option>
               <option value= "='West Point Grey'">West Point Grey</option>
               <option value= "='Musqueam'">Musqueam</option>
               <option value= "='Stanley Park'">Stanley Park</option>
			</select>
		</td>
		</tr>

         <tr>
            <td>crime type</td>
            <td><select name="TYPE">
	            <option value="IS NOT NULL" selected >Choose here</option>            
                  <option value= "='Break and Enter Commercial'">Break and Enter Commercial</option>
                  <option value= "='Break and Enter Residential/Other'">Break and Enter Residential/Other</option>
                  <option value= "='Mischief'">Mischief</option>
                  <option value= "='Other Theft'">Other Theft</option>
                  <option value= "='Theft from Vehicle'">Theft from Vehicle</option>
                  <option value= "='Theft of Bicycle'">Theft of Bicycle</option>
                  <option value= "='Theft of Vehicle'">Theft of Vehicle</option>
                  <option value= "='Vehicle Collision or Pedestrian Struck (with Fatality)'">Vehicle Collision or Pedestrian Struck (with Fatality)</option>
                  <option value= "='Vehicle Collision or Pedestrian Struck (with Injury)'">Vehicle Collision or Pedestrian Struck (with Injury)</option>
            </select></td>
         </tr>  
         <script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>





<tr> 
<td>weather type</td>    
<td><select name = "Weather">
<!-- <option value="IS NOT NULL" selected >Choose here</option> -->
<option value = "any (select Weather from crime_weather)">Choose here</option>

<!-- <script type="text/javascript">
//$('h1').hide();
//for(var i=0; i<24; i++){
//$('#HOUR').append('<option value="'+ i +'">' + i + '</option>');}

 -->
 
<!-- 
  var weatherArray = new Array(); -->

 

  <c:forEach items = "${google_map_weather}" var = "dto">

  	<option value= "'${dto.getWeather() }'" >${dto.getWeather() }</option>
<!--   	weatherArray.push(temp);	 -->
  </c:forEach>

<!--   alert(weatherArray);
  
  $.each(weatherArray , function (index , item) {
  	// 변수를 선언합니다.
  	var output = ";
  	// 문자열을 만듭니다 ./
  	output += '<option value="='= "'"  + item + "'>" + item + "</option>"); 
 -->    
<!-- /*   // 이중 for문 시작
  for ( var j=0; j<7 ; j++) {
   var txt="(" + i + "," + j + ")";    // 테이블각 셀에 (행,열) 값을 출력하기위해 정의된 String
   document.write("<td>"+ txt +"</td>");     // <td> : 열추가.
  } //end for j */


 } //end for i -->
<!-- </script>	
 -->

</select>
</td>
</tr>

	<!-- 	<tr>
			<td>weather type</td>
			<td><select name = "Weather">
	            <option value="IS NOT NULL" selected >Choose here</option>
	            <option value="='Cloudy'"  >Cloudy</option>
	            <option value="='Rain Showers'"  >Rain Showers</option>
	            <option value="='Rain'"  >Rain</option>
	            <option value="='Rain,Fog'"  >Rain,Fog</option>
	            <option value="='Moderate Rain,Fog'"  >Moderate Rain,Fog</option>
	            <option value="='Mostly Cloudy'"  >Mostly Cloudy</option>
	            <option value="='Moderate Rain Showers,Fog'"  >Moderate Rain Showers,Fog</option>
	            <option value="='Mainly Clear'"  >Mainly Clear</option>
	            <option value="='Clear'"  >Clear</option>
	            <option value="='Fog'"  >Fog</option>
	            <option value="='Freezing Fog'"  >Freezing Fog</option>


			</select>
		</td>
			
 -->



			  
         
         <tr>
            <td colspan="2"><input type="submit" value="enter"> &nbsp;&nbsp; 
<!--             <a href="google_map">default map</a></td> -->
        	<button type="button" onclick="location.href='google_map' ">default map</button>
         </tr>


</table>
</form> 
</div>


  
    
    <script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDTyeIPcL6r6LHGIMYpoIMC29IuHcutjpk&libraries=visualization&callback=initMap">
    </script>






&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;



  <div id="map" style="float: right; width: 65%">
    <script>
        function initMap() {
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 12,
          center: {lat: 49.246503, lng: -123.123531}
        });   
        var data = []
        for (i = 0; i < lat1.length; i++) {
            data[i] = new google.maps.LatLng(lat1[i], lon1[i]);
          }
        
        var heatmap = new google.maps.visualization.HeatmapLayer({
//            data: getPoints(),
            data: data,
            map: map
        	});
        }   
        var lat1 = new Array();
        var lon1 = new Array();
        var tem1;
        var tem2;
   			
        <c:forEach items = "${google_map}" var = "dto">
   			tem1 = "<c:out value="${dto.getLatitude()}" />";
   			tem2 = "<c:out value="${dto.getLongitude()}" />";
	
   			lat1.push(tem1);
   			lon1.push(tem2);			
        </c:forEach>
        
/* 			alert(tem1);
   			alert(typeof(tem2));
   			alert(lon1)
   			alert(typeof(lat1))
   			alert(lon1[2])
 */ 
	

        
/* 		function getPoints(){
 			return[
	 			new google.maps.LatLng(49.246503, -123.123531 ),
          	];
		} */
        
       
      </script>

</div>






  </body>
</html>