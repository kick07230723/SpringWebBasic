package org.zerock.spring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




public class MySQLConnectionTest {
	
	public static void main(String[] args) throws Exception {
		
		//5버전 com.mysql.jdbc.Driver
		//6  
		
		String className ="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://192.168.0.17:3306/sample_db?useSSL=false"; 
		String user="bit92";
		String password="bit92";
		
		Class.forName(className);
		Connection con= DriverManager.getConnection(url, user, password);
		System.out.println(con);
		con.close();
	}

}
