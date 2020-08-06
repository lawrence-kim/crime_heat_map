package com.springlec.semi_JDBC.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;
import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.RList;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RFileInputStream;
import org.rosuda.REngine.Rserve.RserveException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.springlec.semi_JDBC.dto.BDto;
import com.springlec.semi_JDBC.util.Constant;




public class BDao {
	JdbcTemplate template;

	public BDao() {
		this.template = Constant.template;
	}

	public ArrayList<BDto> list() {
		String query = "select bId, bName, bTel, bAddress, bEmail, bRelation, bDate from mvc_address";
		return (ArrayList<BDto>) template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));
	}

	public void write(final String bName, final String bTel, final String bAddress, final String bEmail,
			final String bRelation) {
		this.template.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				String query = "insert into mvc_address (bName,bTel,bAddress,bEmail, bRelation, bDate) values (?,?,?,?,?,now())";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, bName);
				pstmt.setString(2, bTel);
				pstmt.setString(3, bAddress);
				pstmt.setString(4, bRelation);
				pstmt.setString(5, bEmail);

				return pstmt;
			}
		});
	}
	
// -----------------------------	
	
//	public ArrayList<BDto> google_map_input(String bYear) {
//		String query = "select Latitude, Longitude from crime_vancouver.crime_weather where YEAR = " + bYear;
//		return (ArrayList<BDto>) template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));
//	}

	
	public ArrayList<BDto> google_map_input(String YEAR, String MONTH, String HOUR, String NEIGHBOURHOOD, String TYPE, String Weather) {
		String query = "select Latitude, Longitude from crime_weather where YEAR  " + YEAR + " and MONTH " + MONTH + " and HOUR " + HOUR + " and NEIGHBOURHOOD " + 
						NEIGHBOURHOOD + " and TYPE " + TYPE + " and Weather="+ Weather +" limit 800";
//		String query = "select Latitude, Longitude from crime_weather where YEAR = " + YEAR ;
		

		//return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));
		ArrayList<BDto> Lon_Lat = (ArrayList<BDto>) template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));
		System.out.println(Lon_Lat.toString());
		return Lon_Lat;
	}

	
	
	public ArrayList<BDto> google_map_weather(){
		String query = "select distinct Weather from crime_weather";
		System.out.println(query);
		return (ArrayList<BDto>) template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));
	}
	
// ---------------------------------------------------------	

	public BDto contentView(String strId) {
		String query = "select * from mvc_address where bId = " + strId;
		return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));

	}

	public void modify(final String bId, final String bName, final String bTel, final String bAddress,
			final String bEmail, final String bRelation) {
		String query = "update mvc_address set bName = ?, bTel = ?, bAddress = ?, bEmail =?, bRelation=? where bId = ?";
		this.template.update(query, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, bName);
				ps.setString(2, bTel);
				ps.setString(3, bAddress);
				ps.setString(4, bEmail);
				ps.setString(5, bRelation);
				ps.setInt(6, Integer.parseInt(bId));

			}
		});

	}

	public void delete(final String bId) {
		String query = "delete from mvc_address where bId = ?";
		this.template.update(query, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, bId);
			}
		});
	}

	// ------------------------------------------------------------------------------------------------------------------------

	// Fields
	// R을 쓰려고 하몀

	public REXP rx = null;
	public RConnection rCon = null; // 연결
	public String rStr = ""; // 리턴값

	// Method
	public String getSum() throws RserveException, REXPMismatchException {
		// R 실행 하다가 getSum() (이거 실행하다가 ) 에거걸리면 throws RserveException,
		// REXPMismatchException 여기로 보내라
		rCon = new RConnection();
		String vector = "seq(1:10)";
		rCon.eval("sumVal <- sum(" + vector + ")"); // R 코드는 여기서 다 실행된다.
		// 섬벨에 알코드가 들어가 있다.
		// 그래서 rCon.eval 여기에 R 코드 다 입력하면
		// 실행된다.
		// 데이터베이스도 연결되고 다 할수 있다.
		String sumT = rCon.eval("sumVal").asString(); // R에서는 벡터인데 sumVal을 스트링으로 바꿔 준다.
		rCon.close();
		return sumT;
	}

	public String getMean() throws RserveException, REXPMismatchException {
		// R 실행 하다가 getSum() (이거 실행하다가 ) 에거걸리면 throws RserveException,
		// REXPMismatchException 여기로 보내라
		rCon = new RConnection();
		String vector = "seq(1:10)";
		rCon.eval("meanVal <- mean(" + vector + ")"); // R 코드는 여기서 다 실행된다.
		// 섬벨에 알코드가 들어가 있다.
		// 그래서 rCon.eval 여기에 R 코드 다 입력하면
		// 실행된다.
		// 데이터베이스도 연결되고 다 할수 있다.
		// rCon.eval 이게 젤 중요

		String meanT = rCon.eval("meanVal").asString(); // R에서는 벡터인데 sumVal을 스트링으로 바꿔 준다.
		rCon.close();
		return meanT;
	}

	public String[][] getIris() throws RserveException, REXPMismatchException { // 2차원으로 받는다.

		rCon = new RConnection();
		RList rLst = rCon.eval("head(iris)").asList();
		int cols = rLst.size();

		String[][] s = new String[cols][];
		// 1차원은 length 갯수 알아야 되지만 2차원은 겈럼수만 알면됨

		for (int i = 0; i < cols; i++) {
			s[i] = rLst.at(i).asStrings();
			// for문이 0 번쨰부터 쫙쫙 들어감 그래서 String
		}
		rCon.close();
		return s;

	}
	// 컬럼하고 rows 를 모른다. 다시!

	public int getIrisCols() throws RserveException, REXPMismatchException {
		rCon = new RConnection();
		RList rLst = rCon.eval("head(iris)").asList();
		int cols = rLst.size();
		rCon.close();
		return cols;

	}

	public int getIrisRows() throws RserveException, REXPMismatchException {
		rCon = new RConnection();
		RList rLst = rCon.eval("head(iris)").asList();
		int rows = rLst.at(0).length();
		rCon.close();
		return rows;

	}

	public String[] getIrisHeader() throws RserveException, REXPMismatchException {
		rCon = new RConnection();
		RList rLst = rCon.eval("head(iris)").asList();
		int cols = rLst.size();

		String[] rHead = new String[cols];
		for (int i = 0; i < cols; i++) {
			String namesT = "names(iris)[" + (i + 1) + "]";
			rHead[i] = rCon.eval(namesT).asString();

		}
		rCon.close();
		return rHead;
	}

	// plot 그리기

//	public byte[] getPlot2() throws RserveException, REXPMismatchException, IOException {
//		// byte R에서 불러오는거 plot은 이미지 저장해서 jsp에 띄우는 식이다.
//
//		rCon = new RConnection();
//
//		rCon.eval("png('irisplot.png')"); // 이미지 이름은 아무거나 상관없다리
//		rCon.eval("plot(iris$Sepal.Length)");
//		rCon.eval("dev.off()");
//
//		RFileInputStream is = rCon.openFile("irisplot.png"); // 이 두개(밑에줄까지) 한쌍이다.!
//		byte[] buf = new byte[9000]; // plot이 반뿐이 안나오면 이거 키우면됨
//										// 이게 이미지 크기
//										// buf 가 순수 이미지 파일이다.
//
//		System.out.println("read" + is.read(buf) + "bytes"); // 그래서 몇바이트 인지 본다.
//																// 이거 프린트된거 보면 3754바이트의 크기이다.
//
//		is.close();
//		rCon.close();
//		return buf; // 그래서 이건 결과값이 png가 날아오는 거다.
//	}

// --------------------------------------------------------------------------------------------------------------------

	


//		 public byte[] getplott() throws RserveException, REXPMismatchException,IOException {
//		     RConnection connection = null; 
////		     try {                
//		     RCaller caller = new RCaller();
//		     caller.setRscriptExecutable("C:\\Program Files\\R\\R-3.6.1\\bin\\x64\\Rscript.exe");
//		     caller.cleanRCode();
//		     caller.addRCode("crime01 <- read.csv('./crime01.csv");
////		     caller.addRCode("crime01_plot <- aggregate(crime_01$TYPE, by=list(Status=crime01$Request.By), FUN=sum)");
//
//		     File file = caller.startPlot();
//		     caller.addRCode("barplot(table(crime01$HOUR)");
//		     caller.endPlot();
//		     caller.runOnly();
//		     ImageIcon ii = caller.getPlot(file);
//		     caller.showPlot(file);
//		     byte[] buf = new byte[9000];
//		     return buf;
//		 	}
////		      catch (RserveException e) {
////		         e.printStackTrace();
////		 }
////		     finally{
////		         connection.close();
////		     }}
		 
	
//	public String getSQL() throws RserveException, REXPMismatchException {
//		rCon = new RConnection();
//		System.out.println("yametaee");
//		rCon.eval("library(DBI)");
//		rCon.eval("library(RMySQL)");
//		rCon.eval("crime_vancouver <- dbConnect(dbDriver(\"MySQL\"), dbname = \"crime_vancouver\", user = \"root\", password = \"1111\")");
//		rCon.eval("crime <- dbGetQuery(crime_vancouver, \"SELECT * FROM crime_weather\")");
//
//		
////		rCon.eval("crime = read.csv('C:\\Users\\user\\Documents\\spring_workspace\\semi_JDBC\\crime_01.csv')");
////		rCon.eval("crime = read.csv('C:/Users/user/Documents/spring_workspace/semi_JDBC/crime_01.csv')");
//		String testT = rCon.eval("crime$TYPE[1]").asString();
//		System.out.println(testT);
//		rCon.close();
//		return testT;
//	}	
//	
	
	  public double getLoc1() throws RserveException, REXPMismatchException, IOException{
		  System.out.println("0000000000000000000000000000");
		  double[] loc = new double[2];
		  double lat = 0.0;
		  double lon = 0.0;
		 
		  rCon = new RConnection();
		  rCon.eval("library(RMySQL)");
		  rCon.eval("library(randomForestSRC)");
		  rCon.eval("conn <- dbConnect(MySQL(),\n" + 
		  		"                 dbname = \"crime_vancouver\",\n" + 
		  		"                  user = \"root\",\n" + 
		  		"                  password = \"1111\",\n" + 
		  		"                  host= \"127.0.0.1\"\n" + 
		  		"                 )");
		  System.out.println("11111111111111111111111111");
		  rCon.eval("crime_weather<-dbGetQuery(conn, 'select*from crime_weather')");
		  rCon.eval("crime_weather_need<-crime_weather[c(2:6,9,16:18,12,13)]");
		  rCon.eval("dbDisconnect(conn)");
		  rCon.eval("for (i in c(1,3:7)){\n" + 
		  		"    crime_weather_need[,i]<-as.factor(crime_weather_need[,i])\n" + 
		  		"}");
		  rCon.eval("crime_weather_need[\"TYPE_number\"] <- as.numeric(crime_weather_need$TYPE)\n" + 
		  		"crime_weather_need[\"MONTH_number\"] <- as.numeric(crime_weather_need$MONTH)\n" + 
		  		"crime_weather_need[\"DAY_number\"] <- as.numeric(crime_weather_need$DAY)\n" + 
		  		"crime_weather_need[\"HOUR_number\"] <- as.numeric(crime_weather_need$HOUR)\n" + 
		  		"crime_weather_need[\"NEIGHBOURHOOD_number\"] <- as.numeric(crime_weather_need$NEIGHBOURHOOD)\n" + 
		  		"crime_weather_need[\"Weather_number\"] <- as.numeric(crime_weather_need$Weather)\n" + 
		  		"");
		  System.out.println("2222222222222222222222222222");
		  rCon.eval("training<-crime_weather_need[c(12,2,13:17,8:11)]");
		  rCon.eval("rf <-rfsrc(Multivar(Latitude, Longitude) ~ . , data=training[1:300,], importance = T)");
		  rCon.eval("TYPE_input<-3; YEAR_input<-2019; MONTH_input<-9; DAY_input<-17; HOUR_input<-17; NEIGHBOURHOOD_input<-24; Weather_input<-7; Temp_input<-12; Rel_Hum_input<-90;");
		  System.out.println("33333333333333333333333333333333333");
		  rCon.eval("input_values<-as.data.frame(as.list(c(TYPE_input,YEAR_input,MONTH_input,DAY_input,HOUR_input,NEIGHBOURHOOD_input,Weather_input,Temp_input,Rel_Hum_input)))");
		  rCon.eval("names(input_values)<-c(\"TYPE_number\",\"YEAR\",\"MONTH_number\",\"DAY_number\",\"HOUR_number\",\"NEIGHBOURHOOD_number\",\"Weather_number\",\"Temp\",\"Rel_Hum\")");
		  System.out.println("444444444444444444444444444444444444");
		  rCon.eval("pred <- predict(rf, input_values)");
		  rCon.eval("coordinates  <- as.data.frame(pred$regrOutput$Latitude$predicted)");
		  rCon.eval("names(coordinates)<-\"Latitude\"");
		  rCon.eval("coordinates[\"Longitude\"] <- pred$regrOutput$Longitude$predicted");
		  lat = rCon.eval("coordinates$Latitude[1]").asDouble();
		  lon = rCon.eval("coordinates$Longitude[1]").asDouble();
		  System.out.println("5555555555555555555555555555555555555");
		  
	      loc[0] = lat;
	      loc[1] = lon;	  
		  
		  
		  System.out.println(lat);
		  System.out.println(lon);
		  rCon.close(); 
		  return lat;		  
	  }
	
	  public double getLoc2() throws RserveException, REXPMismatchException, IOException{
		  System.out.println("0000000000000000000000000000");
		  double[] loc = new double[2];
		  double lat = 0.0;
		  double lon = 0.0;
		 
		  rCon = new RConnection();
		  rCon.eval("library(RMySQL)");
		  rCon.eval("library(randomForestSRC)");
		  rCon.eval("conn <- dbConnect(MySQL(),\n" + 
		  		"                 dbname = \"crime_vancouver\",\n" + 
		  		"                  user = \"root\",\n" + 
		  		"                  password = \"1111\",\n" + 
		  		"                  host= \"127.0.0.1\"\n" + 
		  		"                 )");
		  System.out.println("11111111111111111111111111");
		  rCon.eval("crime_weather<-dbGetQuery(conn, 'select*from crime_weather')");
		  rCon.eval("crime_weather_need<-crime_weather[c(2:6,9,16:18,12,13)]");
		  rCon.eval("dbDisconnect(conn)");
		  rCon.eval("for (i in c(1,3:7)){\n" + 
		  		"    crime_weather_need[,i]<-as.factor(crime_weather_need[,i])\n" + 
		  		"}");
		  rCon.eval("crime_weather_need[\"TYPE_number\"] <- as.numeric(crime_weather_need$TYPE)\n" + 
		  		"crime_weather_need[\"MONTH_number\"] <- as.numeric(crime_weather_need$MONTH)\n" + 
		  		"crime_weather_need[\"DAY_number\"] <- as.numeric(crime_weather_need$DAY)\n" + 
		  		"crime_weather_need[\"HOUR_number\"] <- as.numeric(crime_weather_need$HOUR)\n" + 
		  		"crime_weather_need[\"NEIGHBOURHOOD_number\"] <- as.numeric(crime_weather_need$NEIGHBOURHOOD)\n" + 
		  		"crime_weather_need[\"Weather_number\"] <- as.numeric(crime_weather_need$Weather)\n" + 
		  		"");
		  System.out.println("2222222222222222222222222222");
		  rCon.eval("training<-crime_weather_need[c(12,2,13:17,8:11)]");
		  rCon.eval("rf <-rfsrc(Multivar(Latitude, Longitude) ~ . , data=training[1:300,], importance = T)");
		  rCon.eval("TYPE_input<-3; YEAR_input<-2019; MONTH_input<-9; DAY_input<-17; HOUR_input<-17; NEIGHBOURHOOD_input<-24; Weather_input<-7; Temp_input<-12; Rel_Hum_input<-90;");
		  System.out.println("33333333333333333333333333333333333");
		  rCon.eval("input_values<-as.data.frame(as.list(c(TYPE_input,YEAR_input,MONTH_input,DAY_input,HOUR_input,NEIGHBOURHOOD_input,Weather_input,Temp_input,Rel_Hum_input)))");
		  rCon.eval("names(input_values)<-c(\"TYPE_number\",\"YEAR\",\"MONTH_number\",\"DAY_number\",\"HOUR_number\",\"NEIGHBOURHOOD_number\",\"Weather_number\",\"Temp\",\"Rel_Hum\")");
		  System.out.println("444444444444444444444444444444444444");
		  rCon.eval("pred <- predict(rf, input_values)");
		  rCon.eval("coordinates  <- as.data.frame(pred$regrOutput$Latitude$predicted)");
		  rCon.eval("names(coordinates)<-\"Latitude\"");
		  rCon.eval("coordinates[\"Longitude\"] <- pred$regrOutput$Longitude$predicted");
		  lat = rCon.eval("coordinates$Latitude[1]").asDouble();
		  lon = rCon.eval("coordinates$Longitude[1]").asDouble();
		  System.out.println("5555555555555555555555555555555555555");
		  
	      loc[0] = lat;
	      loc[1] = lon;	  
		  
		  
		  System.out.println(lat);
		  System.out.println(lon);
		  rCon.close(); 
		  return lon;		  
	  }	
//	
//	  public byte[] getPlot() throws RserveException, REXPMismatchException, IOException{ 
//		  rCon = new RConnection();
//		  rCon.eval("library(DBI)");
//		  rCon.eval("library(RMySQL)");
//		  rCon.eval("crime_vancouver <- dbConnect(dbDriver('MySQL'), dbname = 'crime_vancouver', user = 'root', password = '1111')");
//		  rCon.eval("crime <- dbGetQuery(crime_vancouver, 'SELECT * FROM crime_weather')");
//		  rCon.eval("crime = read.csv('C:\\Users\\ur\\Documents\\spring_workspace\\semi_JDBC\\crime_01.csv')");
//		  rCon.eval("crime_type1 = crime[crime$TYPE_revised==1,] " +
//		  "crime_type6 = crime[crime$TYPE_revised==6,] " +
//		  "crime_type10 = crime[crime$TYPE_revised==10,] " +
//		  "crime_type5 = crime[crime$TYPE_revised==5,] " +
//		  "crime_type0 = crime[crime$TYPE_revised==0,] " +
//		  "crime_type3 = crime[crime$TYPE_revised==3,] " +
//		 "crime_type8 = crime[crime$TYPE_revised==8,] " +
//		  "crime_type9 = crime[crime$TYPE_revised==9,] " +
//		  "crime_type7 = crime[crime$TYPE_revised==7,] ");
//		  
//		  
//		  rCon.eval("png('crime01.png')");
////		  rCon.eval("barplot(table(crime$TYPE, crime$YEAR))");
//		  rCon.eval("barplot(table(crime_type1$NEIGHBOURHOOD_revised)), main ='Break and Enter Residential/Other') "
//		  +"barplot(sort(table(crime_type6$NEIGHBOURHOOD_revised)),las=2 , main = 'Theft from Vehicle') "
//		  +"barplot(sort(table(crime_type10$NEIGHBOURHOOD_revised)),las=2, main = 'Vehicle Collision or Pedestrian Struck (with Injury)') "
//		  +"barplot(sort(table(crime_type5$NEIGHBOURHOOD_revised)),las=2, main = 'Other Theft') "
//		  +"barplot(sort(table(crime_type0$NEIGHBOURHOOD_revised)),las=2, main = 'Break and Enter Commercial') "
//		  +"barplot(sort(table(crime_type3$NEIGHBOURHOOD_revised)),las=2, main = 'Mischief') "
//		  +"barplot(sort(table(crime_type8$NEIGHBOURHOOD_revised)),las=2, main = 'Theft of Vehicle') "
//		  +"barplot(sort(table(crime_type9$NEIGHBOURHOOD_revised)),las=2, main = 'Vehicle Collision or Pedestrian Struck (with Fatality)') "
//		  +"barplot(sort(table(crime_type7$NEIGHBOURHOOD_revised)),las=2, main = 'Theft of Bicycle') " );
//		  rCon.eval("dev.off()");
//	  
//		  
//		  RFileInputStream is = rCon.openFile("crime01.png"); 
//		  byte[] buf2 = new byte[10000]; 
//		  System.out.println("read" + is.read(buf2)+ "bytes"); 
//		  is.close(); 
//		  rCon.eval("dbDisconnect(crime_vancouver)");
//		  rCon.close(); 
//		  return buf2;
//	  }
//	  
	  public byte[] wordcloud() throws RserveException, REXPMismatchException, IOException{ 
	  rCon = new RConnection();

rCon.eval("text  <-readLines('./Data/word_test3.txt')");


rCon.eval("docs <- Corpus(VectorSource(text))");

rCon.eval("dtm <-  TermDocumentMatrix(docs)"
	 + " m <- as.matrix(dtm)"
	 + " v <- sort(rowSums(m),decreasing=T)"
	 + " d <- data.frame(word=names(v),freq=v)");
	  
rCon.eval("png('vc_wordcloud.png')"); 
rCon.eval(" wordcount <- table(d)"

	 + " palete <- brewer.pal(8, 'Dark2')"
	+ " wordcloud(words = d$word,"
+	         " freq = d$freq,"
	+         " min.freq =2,"
	       + " max.words = 200,"
	     +      " random.order = F,"
	   +       "  rot.per = 0.35," 
	 +         "  colors = palete )");
rCon.eval("dev.off()");
RFileInputStream is = rCon.openFile("vc_wordcloud.png"); 
byte[] buf2 = new byte[10000]; 
System.out.println("read" + is.read(buf2)+ "bytes"); 
is.close(); 
rCon.eval("dbDisconnect(crime_vancouver)");
rCon.close(); 
return buf2;	  
		 

	  }
}
