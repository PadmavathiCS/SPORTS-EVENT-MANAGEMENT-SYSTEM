package sportsManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class StudentDetails extends JFrame {

	private JPanel contentPane;
	private JTextField rollno;
	private JTextField name;
	private JTextField std;
	private JTextField age;
	static String event;
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
					StudentDetails frame = new StudentDetails();
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
	public StudentDetails() {
		
		StaffOp staffOp=new StaffOp();
		 event=staffOp.event;
		 System.out.println(event);
		 
		 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 758, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Details");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(268, 22, 374, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Roll No");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(99, 102, 89, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(99, 147, 89, 32);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Age");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setBounds(99, 258, 64, 21);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Class");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_4.setBounds(99, 203, 75, 21);
		contentPane.add(lblNewLabel_4);
		
		rollno = new JTextField();
		rollno.setBounds(286, 203, 126, 22);
		contentPane.add(rollno);
		rollno.setColumns(10);
		
		name = new JTextField();
		name.setBounds(286, 102, 126, 22);
		contentPane.add(name);
		name.setColumns(10);
		
		std = new JTextField();
		std.setBounds(286, 258, 126, 22);
		contentPane.add(std);
		std.setColumns(10);
		
		age = new JTextField();
		age.setBounds(286, 147, 126, 28);
		contentPane.add(age);
		age.setColumns(10);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					
					String query="insert into "+event+" (rollno,age) values(?,?)";
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection = DriverManager.getConnection(url,uName,pass);
					PreparedStatement preparedstatement =connection.prepareStatement(query);
					int rno=Integer.parseInt(rollno.getText());
					//String sname=name.getText().toString();
					//String cname=std.getText().toString();
					int age1=Integer.parseInt(age.getText());
					preparedstatement.setInt(1, rno);
					//preparedstatement.setString(2, sname);
					//preparedstatement.setString(3, clne);
					preparedstatement.setInt(2, age1);
					int count=preparedstatement.executeUpdate();
					System.out.println(count+" student enrolled successfully!! in "+event);
					preparedstatement.close();
					connection.close();
				}
				catch (Exception e1) {
					System.out.println(e1);
				}
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnNewButton.setBounds(219, 362, 152, 32);
		contentPane.add(btnNewButton);
		
	}
}
