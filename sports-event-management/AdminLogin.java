package sportsManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JButton btnNewButton;
	private JPasswordField passwordField;
	
	@SuppressWarnings("unlikely-arg-type")
	public boolean adminLogin()
	{
		//It stores userName:password
				//Initializing default userName and Password
			    HashMap<String,String> userAndPass=new HashMap<String,String>(Map.of("admin","admin@123"));
		String uname = username.getText();
		char [] password = passwordField.getPassword();
		//System.out.println(pass);
		String pass = String.valueOf(password);
		if(userAndPass.containsKey(uname) && userAndPass.get(uname).equals(pass)) {
			JOptionPane.showMessageDialog(this, "LOGIN SUCCESSFULL!!");
			return true;
		}
		return false;
	}



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
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
	public  AdminLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 345);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("username");
		lblNewLabel.setForeground(new Color(135, 206, 250));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBounds(186, 122, 133, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("password");
		lblNewLabel_1.setForeground(new Color(135, 206, 235));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1.setBounds(186, 183, 133, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ADMIN LOGIN");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblNewLabel_2.setBounds(231, 10, 286, 79);
		contentPane.add(lblNewLabel_2);
		
		username = new JTextField();
		username.setFont(new Font("Times New Roman", Font.BOLD, 13));
		username.setBounds(393, 122, 124, 24);
		contentPane.add(username);
		username.setColumns(10);
		
		btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean validate=adminLogin();
				if(validate)
				{
					Adminop adminop = new Adminop();
					adminop.show();
					dispose();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setForeground(new Color(220, 20, 60));
		btnNewButton.setBounds(298, 252, 105, 21);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(393, 184, 124, 23);
		contentPane.add(passwordField);
	}
}
