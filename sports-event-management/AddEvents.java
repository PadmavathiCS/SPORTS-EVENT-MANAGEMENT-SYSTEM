package sportsManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AddEvents extends JFrame {

	public JPanel contentPane;
	public JTextField eid;
	public JTextField ename;
	public JTextField edate;
	public JTextField sid;
	public JTextField sname;
	public JTextField etype;

	public static final String url="jdbc:mysql://localhost:3306/sports_event_management";
    public static final String uName="root";
    public static final String pass="lalithamangalam12345*";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					AddEvents frame = new AddEvents();
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
	public AddEvents() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 737, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Adding Event Details");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBounds(221, 10, 233, 55);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Event id");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(80, 86, 74, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Event Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(48, 147, 106, 27);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Event Date");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(60, 204, 94, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Event Type");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(60, 256, 94, 27);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Staff id");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(92, 311, 59, 27);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Staff Name");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6.setBounds(60, 371, 94, 27);
		contentPane.add(lblNewLabel_6);
		
		eid = new JTextField();
		eid.setBounds(221, 86, 152, 32);
		contentPane.add(eid);
		eid.setColumns(10);
		
		ename = new JTextField();
		ename.setBounds(221, 147, 152, 27);
		contentPane.add(ename);
		ename.setColumns(10);
		
		edate = new JTextField();
		edate.setBounds(221, 199, 152, 27);
		contentPane.add(edate);
		edate.setColumns(10);
		
		sid = new JTextField();
		sid.setBounds(221, 311, 152, 27);
		contentPane.add(sid);
		sid.setColumns(10);
		
		sname = new JTextField();
		sname.setBounds(221, 371, 152, 25);
		contentPane.add(sname);
		sname.setColumns(10);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try 
				{
					
					String query="insert into events values(?,?,?,?,?,?)";
	  				  Class.forName("com.mysql.cj.jdbc.Driver");
	  				  Connection connection = DriverManager.getConnection(url,uName,pass);
	  				  PreparedStatement preparedstatement =connection.prepareStatement(query);
	  				  int evid = Integer.parseInt(eid.getText());
	  				  String evname = ename.getText().toString();
	  				  String evdate=edate.getText().toString();
	  				  String evtype=etype.getText().toString();
	  				  int stid =Integer.parseInt(sid.getText()); 
	  				  String stname=ename.getText().toString();
	  				  preparedstatement.setInt(1, evid);
	  				  preparedstatement.setString(2, evname);
	  				  preparedstatement.setString(3, evdate);
	  				  preparedstatement.setString(4, evtype);
	  				  preparedstatement.setInt(5,stid );
	  				  preparedstatement.setString(6, stname);
	  				  preparedstatement.executeUpdate();
	  				  System.out.println();
	  				  createTable(evname);
	  				  //System.out.println(count+" events and staffs mapped successfully!!");
	  				  preparedstatement.close();
	  				  connection.close();
	  				dispose();
					
				}
				catch(Exception e1)
				{
					dispose();
					System.out.println(e);
				}
				Adminop admin = new Adminop();
				admin.show();
				
				
			}
			public void createTable(String ename) {
		  		String query="create table "+ename+"(rollno int,sname varchar(50),class varchar(3),age int, score varchar(6) default null)";
		  		try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection = DriverManager.getConnection(url,uName,pass);
					PreparedStatement statement = connection.prepareStatement(query);
					statement.executeUpdate();
						
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(263, 425, 106, 21);
		contentPane.add(btnNewButton);
		
		etype = new JTextField();
		etype.setBounds(221, 256, 148, 25);
		contentPane.add(etype);
		etype.setColumns(10);
	}
}
