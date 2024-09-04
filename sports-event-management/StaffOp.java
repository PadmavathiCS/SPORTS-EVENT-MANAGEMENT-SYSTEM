package sportsManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StaffOp extends JFrame {
	
	
	static String event  ;
	private JPanel contentPane;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffOp frame = new StaffOp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
				
			}
		});
		
	}
	
	/**
	 * Create the frame.
	 * @param event2 
	 * @param event2 
	 */
	public StaffOp(){
		
		StaffLogin s=new StaffLogin();
		
		event=s.event;
		System.out.println(event);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 712, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("STAFF OPERATIONS");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(209, 20, 276, 43);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add Students");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentDetails sd=new StudentDetails();
				sd.show();
				dispose();
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(243, 73, 173, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update Results");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_1.setBounds(243, 123, 173, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("View Results");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_2.setBounds(243, 178, 173, 29);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("View Students");
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_3.setBounds(243, 234, 173, 29);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Quit");
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_4.setBounds(243, 292, 173, 29);
		contentPane.add(btnNewButton_4);
		
		
	}
	
	
	
	
}
