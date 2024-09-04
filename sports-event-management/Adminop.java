package sportsManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class Adminop extends JFrame{

	private JPanel contentPane;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adminop frame = new Adminop();
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
	public Adminop() {
		setForeground(new Color(255, 128, 128));
		setBackground(new Color(255, 128, 128));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 380);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 128, 128));
		contentPane.setForeground(new Color(255, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setBounds(0, 0, 0, 263);
		contentPane.add(lblNewLabel);
		
		JButton addevent = new JButton("Add Events");
		addevent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddEvents addEvents=new AddEvents();
				addEvents.show();
				
				  
			}
		});
		addevent.setFont(new Font("Times New Roman", Font.BOLD, 15));
		addevent.setBounds(244, 83, 142, 27);
		contentPane.add(addevent);
		
		JButton viewstud = new JButton("View Students");
		viewstud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			    }

		});
		viewstud.setFont(new Font("Times New Roman", Font.BOLD, 15));
		viewstud.setBounds(244, 133, 142, 27);
		contentPane.add(viewstud);
		
		JButton viewres = new JButton("View Results");
		viewres.setFont(new Font("Times New Roman", Font.BOLD, 15));
		viewres.setBounds(244, 185, 142, 27);
		contentPane.add(viewres);
		
		JButton viewevents = new JButton("View Events");
		viewevents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Table jtb=new Table();
				jtb.show();
				
			}
		});
		viewevents.setFont(new Font("Times New Roman", Font.BOLD, 15));
		viewevents.setBounds(244, 236, 142, 27);
		contentPane.add(viewevents);
		
		JButton quit = new JButton("Quit");
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginAs ls=new LoginAs();
				ls.show();
				dispose();
			}
		});
		quit.setFont(new Font("Times New Roman", Font.BOLD, 15));
		quit.setBounds(244, 289, 142, 27);
		contentPane.add(quit);
		
		JLabel lblNewLabel_1 = new JLabel("ADMIN OPERATIONS");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(206, 10, 294, 51);
		contentPane.add(lblNewLabel_1);
	}
}
