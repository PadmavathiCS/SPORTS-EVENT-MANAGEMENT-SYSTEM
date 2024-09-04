package sportsManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Staff extends Admin{
	
	public boolean doStaffValidate(String userName1, String password1) {
		
		String userName;
		String password;
		String event=null;
	 	String sname=null;
	 	int id;
		
		 try {
			 
			 	Class.forName("com.mysql.cj.jdbc.Driver");
			 	Connection connection = DriverManager.getConnection(url,uName,pass);
			 	PreparedStatement pstmt = connection.prepareStatement("select name_of_the_event , staff_id , staff_name from events where staff_name = ?");
			 	pstmt.setString(1, userName1);
			 	ResultSet rs = pstmt.executeQuery();
			 	while(rs.next())
			 	{
			 		event=rs.getString(1);
			 		id=rs.getInt(2);
			 		sname=rs.getString(3);
			 		if(sname.equals(sname) )
				 	{
				 		System.out.println("LOGIN SUCCESSFULL!!!!");
				 		return true;
				 	}
				 	else 
				 	{
				 		System.out.println("NO");
				 		return false;	 
				 	}
			 	}
			 	System.out.println(userName1+" "+password1);
			 	
		 	} 
		 catch (Exception e) 
		 {
			
			e.printStackTrace();
		}
		 
		
		return false;
		
	}

}
