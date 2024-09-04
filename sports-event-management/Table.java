package sportsManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;

public class Table extends JFrame {

	private JPanel contentPane;
	private javax.swing.JTable jt1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Table frame = new Table();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
public Table() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(300, 300, 600, 705);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
	setContentPane(contentPane);
	contentPane.setLayout(null);
		
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(50,50,604,600);
	contentPane.add(scrollPane);
	//My_test obj=new My_test();// with test data
	//my_mysql obj=new my_mysql();
		
	String[] column= {"eventid","name_of_the_event","date","type_of_the_event","staff_id","staff_name"};
	
//jt1=new javax.swing.JTable(obj.my_test_select(),column);//test data
	
	jt1 = new javax.swing.JTable(my_db_select(),column);
	
	scrollPane.setViewportView(jt1);
	}
public  String[][] my_db_select() {
////////////
String[][] data = new String[30][7]; // [rows][columns]

try{  
Class.forName("com.mysql.cj.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/sports_event_management","root","lalithamangalam12345*");  
Statement st=con.createStatement();  

ResultSet rs=st.executeQuery("SELECT * FROM events"); 
//Looping to store result in returning array data // 
int i=0;
while(rs.next())  {
for(int j=0;j<=5;j++) {
//System.out.print(rs.getString(j+1));
data[i][j]=rs.getString(j+1);
}
//System.out.println();
i=i+1;
}
//Below lines to check data before returning. // 	
/*		
for (int x=0;x<data.length;x++) {
for (int y=0;(data[x]!= null && y <data[x].length);y++) {
	 System.out.print(data[x][y] + " ");
}
System.out.println();
}
*/
con.close();  
}catch(Exception e){ System.out.println(e);} 
//////////////////////////////

return data;
}

}

