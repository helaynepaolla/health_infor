package AppInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {
public	Connection	getConnection() throws ClassNotFoundException	{
		
		try	{
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			//Class.forName (" com.mysql.jdbc.Driver ");
			//?useTimezone=true&serverTimezone=America/Sao_Paulo
			return	(Connection) DriverManager.getConnection(	
           "jdbc:mysql://localhost:3306/bd_app?useTimezone=true&serverTimezone=America/Sao_Paulo", "root", "");
			//"jdbc:mysql://sql311.epizy.com:3306/epiz_25596661_bd_app?useTimezone=true&serverTimezone=America/Sao_Paulo", "epiz_25596661", "JuyevxgZoOCxymC");
		}	catch	(SQLException	e)	{					
				throw	new	RuntimeException(e);				
			}
    }

}
