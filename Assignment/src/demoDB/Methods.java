package demoDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Methods {
	
	private static final String connectionURL = "jdbc:mysql://localhost:3306/eclipse?useSSL=false";
	private static final String user = "root";
	private static final String password = "password";
	private static Connection con;
	private static PreparedStatement stmt;
	
	public static void makeConnection() throws SQLException,ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(connectionURL, user, password);
		
	}
	
	public static void insert(String table, String[] fields) throws SQLException{
		stmt = con.prepareStatement("insert into " + table + " values(?,?,?,?,?);");
		for(int i=0; i<fields.length; i++){
			stmt.setString(i+1, fields[i]);
		}
	    stmt.execute();
	}

}
