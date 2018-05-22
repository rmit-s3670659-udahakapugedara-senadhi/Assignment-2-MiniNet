
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hsqldb.Server;

public class DBConnection {

	
	public static void main(String[] args) {
		Server hsqlServer = null;
		Connection connection = null;
		ResultSet rs = null;
		
		hsqlServer = new Server();
		hsqlServer.setLogWriter(null);
		hsqlServer.setSilent(true);
		hsqlServer.setDatabaseName(0, "MiniNetDB");
		hsqlServer.setDatabasePath(0, "file:MYDB");
		
		hsqlServer.start();
		
		// making a connection
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			connection = DriverManager.getConnection("jdbc:hsqldb:MiniNetDB", "sa", "123");
			
		
			connection.prepareStatement("drop table users if exists;").execute();
			connection.prepareStatement("create table users (username String, status varchar(200),sex varchar(5), age varchar(3), state varchar(5));").execute();
			connection.prepareStatement("insert into users (username, status, sex, age, state)" 
					+ "values ('Chikara', 'Im Good','Male','25','VIC');").execute();
//			
//			// query from the db
//			rs = connection.prepareStatement("select id, barcode  from barcodes;").executeQuery();
//			rs.next();
//			System.out.println(String.format("ID: %1d, Name: %1s", rs.getInt(1), rs.getString(2)));
			connection.commit();
		} catch (SQLException e2) {
			e2.printStackTrace();
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}
		
		
		
		// end of stub code for in/out stub
	}
	
	

	
	
	
	
	
}
