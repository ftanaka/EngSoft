package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection(){
		try{
			return DriverManager.getConnection(
					"jdbc:mysql://localhost/fase2","root","shukuchi");
		} catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
}
