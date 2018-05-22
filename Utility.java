
public class Utility {
	
	

	public Utility() {
		
	}
	

}







//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import org.hsqldb.Server;
//
//public class DBConnection {
//	Server hsqlServer = null;
//	Connection connection = null;
//	ResultSet rs = null;
//	
//	hsqlServer = new Server();
//	hsqlServer.setLogWriter(null);
//	hsqlServer.setSilent(true);
//	hsqlServer.setDatabaseName(0, "MiniNetDB");
//	hsqlServer.setDatabasePath(0, "file:MYDB");
//	hsqlServer.start();
//	Class.forName("org.hsqldb.jdbcDriver");
//	connection = DriverManager.getConnection("jdbc:hsqldb:MiniNetDB", "sa", "123");
//	
// public DBConnection() {
//		try {
//			connection.prepareStatement("drop table users if exists;").execute();
//			connection.prepareStatement("create table users (username String, status varchar(200),sex varchar(5), age varchar(3), state varchar(5));").execute();
//			connection.prepareStatement("insert into users (username, status, sex, age, state)" 
//					+ "values ('Chikara', 'Im Good','Male','25','VIC');").execute();		
//			
//
//			rs = connection.prepareStatement("select id, barcode  from barcodes;").executeQuery();
//			rs.next();
//			System.out.println(String.format("ID: %1d, Name: %1s", rs.getInt(1), rs.getString(2)));
//			connection.commit();
//		} catch (SQLException e2) {
//			e2.printStackTrace();
//		} catch (ClassNotFoundException e2) {
//			e2.printStackTrace();
//		}
//		
// }
//
//	
//	public void insertUsers(String username, String status, String sex, String age, String state, String type) {
//		connection.prepareStatement("insert into users (username, status, sex, age, state)" 
//				+ "values (username, status,sex, age, state, type);").execute();	
//		connection.commit();
//	}
//	
//	public void DisplayUser(String Username) {
//		rs = connection.prepareStatement("select username, status,sex, age, state, type;" + "where username = Username;").executeQuery();			
//		connection.commit();
//	}
//	
//	
//	
//	
//	
//}

