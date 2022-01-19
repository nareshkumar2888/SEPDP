package org.project;


import java.sql.DriverManager;

import java.sql.SQLException;


import com.mysql.jdbc.Connection;


import com.mysql.*;

public class DBConnect {


public static Connection getconn() throws SQLException, ClassNotFoundException
{

		Class.forName("com.mysql.jdbc.Driver");
		
                 Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sepdp","root","root");
	
	return con; 	
	
	}

}
