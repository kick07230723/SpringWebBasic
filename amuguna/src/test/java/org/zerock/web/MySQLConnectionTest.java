package org.zerock.web;

import java.sql.Connection;
import java.sql.DriverManager;



public class MySQLConnectionTest {
	
	//badcode
	public static void main(String[] args)throws Exception {
		
		//MySQL  5.x com.mysql.jdbc.Driver
		//MySQl  6.x com.mysql.cj.jdbc.Driver
		
		String className ="com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://192.168.0.17:3306/sample_db?useSSL=false"; //useSSL쓰지 않겠다 보안 안쓰겠다.
		String user = "bit92";
		String password = "bit92";
		
		Class.forName(className);
		
		Connection con = DriverManager.getConnection(url,user,password);
				
		System.out.println(con);
		
		con.close();
		
		
	}
	
	
}
