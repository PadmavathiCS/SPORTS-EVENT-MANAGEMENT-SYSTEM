package sportsManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Operations {
	

		public static final String url="jdbc:mysql://localhost:3306/sports_event_management";
	    public static final String uName="root";
	    public static final String pass="lalithamangalam12345*";
	    
		public void viewResults(String event)
		{
			String query =  "select * from "+event+" order by score desc limit 3";
			//String query1 = "select * from "+event+" order by score limit 3";
			try 
			{

				
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection = DriverManager.getConnection(url,uName,pass);
				Statement statement = connection.createStatement();
				ResultSet resultset = statement.executeQuery(query);
				while(resultset.next())
				{
					int rno = resultset.getInt(1);
					String name = resultset.getString(2);
					String cls = resultset.getString(3);
					int age = resultset.getInt(4);
					String score=resultset.getString(5);
					System.out.println(rno+"\t"+name+"\t"+cls+"\t"+age+"\t"+score);
				}
				
			}
			catch (Exception e) {
				System.out.println(e);
			}
		}
		
		public static void viewStudents(String event) {

			 try {
		  			String query="Select * from "+event;
					
		  			Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection = DriverManager.getConnection(url,uName,pass);
					Statement statement = connection.createStatement();
					ResultSet resultset = statement.executeQuery(query);
					
					//TheEvent      date      typeOfTheEvent      staffId      staffName      ");
					while(resultset.next())
					{
						int rno = resultset.getInt(1);
						String name = resultset.getString(2);
						String cls = resultset.getString(3);
						int age = resultset.getInt(4);
						String score= resultset.getString(5);
						System.out.println(rno+"\t"+name+"\t"+cls+"\t"+age+"\t"+score);
					}
					if(!resultset.next())
					{
						System.out.println("No Records Found");
					}
					
				} 
			 catch (Exception e) {
					
					System.out.println(e);
				}

	}
		

		public boolean doStaffValidate(String userName1, String password1) {
			
			
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
