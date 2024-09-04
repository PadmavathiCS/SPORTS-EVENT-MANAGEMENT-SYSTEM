package sportsManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Admin extends Operations{
	
	//admin login parameters
		public String adminName;
		public String adminPassword;
	    
		static //It stores userName:password
		//Initializing default userName and Password
	    HashMap<String,String> userAndPass=new HashMap<String,String>(Map.of("admin","admin@123"));
		
		//To store event and event id
		ArrayList<String> eventAndEventid = new ArrayList<String>();
		
		//for storing list of events added
		 public List<String>eventList = new ArrayList<String>();
		 
		 String event;
		 

		 /*public Admin() 
		  {
			super();
			getInput();
			actionPerformer();
		  }*/
		 
		 public void addEvents(List<String> eventList)
	  	 {
	  		 try {
	  			   int eventId;
	  			   String nameOfTheEvent;
	  			  String date;
	  			  String typeOfTheEvent;
	  			  int staffId;
	  			  String staffName;
	  			
	  			  @SuppressWarnings("resource")
				Scanner scanner = new Scanner(System.in);			  
	  			
	  			  
	  			System.out.println("Enter Event Id:");
	  			  eventId=scanner.nextInt();
	  			System.out.println("Enter the name of the event:");
	  			  nameOfTheEvent=scanner.next();
	  			  
	  			  
	  			  if(!(eventList.contains(nameOfTheEvent)))
	  			  {
		  			  System.out.println(eventList);
	  				  System.out.println("Enter the date of event:");
	  				  date=scanner.next();
	  				  System.out.println("Enter the type of the event:");
	  				  typeOfTheEvent=scanner.next();
	  				  System.out.println("***ENTER THE STAFF DETAILS FOR THE EVENT***");
	  				  System.out.println("Enter the staff id:");
	  				  staffId=scanner.nextInt();
	  				  System.out.println("Enter the staff name:");
	  				  staffName=scanner.next();
	  				  //To store Staff details
	  				  HashMap<String,String> loginAndPass=new HashMap<String,String>();
	  				  loginAndPass.put(staffName, staffName);
	  				  //query
	  				  String query="insert into events values(?,?,?,?,?,?)";
	  				  Class.forName("com.mysql.cj.jdbc.Driver");
	  				  Connection connection = DriverManager.getConnection(url,uName,pass);
	  				  PreparedStatement preparedstatement =connection.prepareStatement(query);
	  				  preparedstatement.setInt(1, eventId);
	  				  preparedstatement.setString(2, nameOfTheEvent);
	  				  preparedstatement.setString(3, date);
	  				  preparedstatement.setString(4, typeOfTheEvent);
	  				  preparedstatement.setInt(5, staffId);
	  				  preparedstatement.setString(6, staffName);
	  				  int count=preparedstatement.executeUpdate();
	  				  createTable(nameOfTheEvent);
	  				  System.out.println(count+" events and staffs mapped successfully!!");
	  				  preparedstatement.close();
	  				  connection.close();
	  			  }
	  			  else {
	  				  System.out.println("SORRY>>> THE EVENT IS ALREADY ADDED!!");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  		 
	  	 }
		 
		 //method to create a table for a newly created event
	  	 private void createTable(String nameOfTheEvent) {
	  		String query="create table "+nameOfTheEvent+"(rollno int,sname varchar(50),class varchar(3),age int, score varchar(6) default null)";
	  		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection = DriverManager.getConnection(url,uName,pass);
				Statement statement = connection.createStatement();
				statement.addBatch(query);
				statement.executeBatch();
					
			} catch (Exception e) {
				e.printStackTrace();
			}
			  
		}
	  	 
	  	//method to fetch all tables  from the database
			public List<String> events()
			{	
				List<String> eventList =  new ArrayList<String>();
				try 
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection = DriverManager.getConnection(url,uName,pass);
					Statement statement = connection.createStatement();
					ResultSet resultset = statement.executeQuery("show tables");
					 while(resultset.next()) {
				         eventList.add(resultset.getString(1));
				         System.out.println();
				      }
				}
				catch(Exception e)
				{
					
				}
				return eventList;
		}

}
