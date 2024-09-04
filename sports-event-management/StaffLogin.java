package sportsManagementSystem;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.jar.Attributes.Name;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;

public class StaffLogin extends JFrame {
	public static final String url="jdbc:mysql://localhost:3306/sports_event_management";
    public static final String uName="root";
    public static final String pass="lalithamangalam12345*";
    

	private JPanel contentPane;
	private JTextField user;
	private JPasswordField passwordField;
	String event="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffLogin frame = new StaffLogin();
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
	public StaffLogin() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 345);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel username = new JLabel("username");
		username.setForeground(new Color(135, 206, 250));
		username.setFont(new Font("Times New Roman", Font.BOLD, 22));
		username.setBounds(186, 122, 133, 24);
		contentPane.add(username);
		
		JLabel lblNewLabel_1 = new JLabel("password");
		lblNewLabel_1.setForeground(new Color(135, 206, 235));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1.setBounds(186, 183, 133, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("STAFF LOGIN");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblNewLabel_2.setBounds(231, 10, 286, 79);
		contentPane.add(lblNewLabel_2);
		
		user = new JTextField();
		user.setBounds(358, 122, 115, 24);
		contentPane.add(user);
		user.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(358, 183, 115, 25);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean validate=staffLogin();
				
				if(validate)
				{
					StaffOp sop=new StaffOp();
					sop.show();
					dispose();
				}
			}

			 boolean staffLogin() {
				
				String sname;
				int id;
				String uname = user.getText();
				char [] password = passwordField.getPassword();
				String passw = String.valueOf(password);
				
				 try {
					 
					 	Class.forName("com.mysql.cj.jdbc.Driver");
					 	Connection connection = DriverManager.getConnection(url,uName,pass);
					 	PreparedStatement pstmt = connection.prepareStatement("select name_of_the_event , staff_id , staff_name from events where staff_name = ?");
					 	pstmt.setString(1, uname);
					 	ResultSet rs = pstmt.executeQuery();
					 	while(rs.next())
					 	{
					 		String eve=rs.getString(1);
					 		id=rs.getInt(2);
					 		event+=eve;
					 		System.out.println(event);
					 		sname=rs.getString(3);
					 		System.out.println(sname);
					 		if(sname.equals(passw))
						 	{
						 		
						 		return true;
						 	}
					 	}
						 		return false;	 
						 	
					 	
					 	
				 	} 
				 catch (Exception e) 
				 {
					
					e.printStackTrace();
				}
				return false;
			}
			 
			 
			
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setBounds(301, 241, 115, 33);
		contentPane.add(btnNewButton);
		
		
	}
}
