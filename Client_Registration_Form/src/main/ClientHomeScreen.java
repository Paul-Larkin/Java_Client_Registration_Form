package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;

public class ClientHomeScreen {
	
	String firstName;
	String lastName;
	String username;
	String email;

	JFrame frame;
	
	JLabel lblFirstName;
	JLabel lblLastName;
	JLabel lblUsername;
	JLabel lblEmail;
	
	JLabel lblFirstNameText;
	JLabel lblLastNameText;
	JLabel lblUsernameText;
	JLabel lblEmailText;

	JButton editDetailsButton;
	JButton logOutButton;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;

	public ClientHomeScreen(String fname, String lname, String uname, String email) {
		firstName = fname;
		lastName = lname;
		username = uname;
		email = email;
		
		// Frame
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// First Name label
		lblFirstName = new JLabel("First Name");
		lblFirstName.setHorizontalAlignment(SwingConstants.LEFT);
		lblFirstName.setFont(new Font("Calibri", Font.BOLD, 14));
		lblFirstName.setBounds(114, 54, 75, 20);
		frame.getContentPane().add(lblFirstName);
		
		// last Name Label
		lblLastName = new JLabel("Last Name");
		lblLastName.setHorizontalAlignment(SwingConstants.LEFT);
		lblLastName.setFont(new Font("Calibri", Font.BOLD, 14));
		lblLastName.setBounds(114, 85, 75, 20);
		frame.getContentPane().add(lblLastName);
		
		// Username Label
		lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername.setFont(new Font("Calibri", Font.BOLD, 14));
		lblUsername.setBounds(114, 115, 75, 20);
		frame.getContentPane().add(lblUsername);
		
		// Email Label
		lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setFont(new Font("Calibri", Font.BOLD, 14));
		lblEmail.setBounds(114, 146, 75, 20);
		frame.getContentPane().add(lblEmail);
			
		// Firstname text Label
		lblFirstName = new JLabel(firstName);
		lblFirstName.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblFirstName.setBounds(221, 54, 98, 20);
		frame.getContentPane().add(lblFirstName);
		
		// Lastname text Label
		lblLastName = new JLabel(lastName);
		lblLastName.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblLastName.setBounds(221, 85, 98, 20);
		frame.getContentPane().add(lblLastName);
		
		// Username text Label
		lblUsername = new JLabel(username);
		lblUsername.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblUsername.setBounds(221, 115, 98, 20);
		frame.getContentPane().add(lblUsername);
		
		// eEmail text Label
		lblEmail = new JLabel(email);
		lblEmail.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblEmail.setBounds(221, 146, 98, 20);
		frame.getContentPane().add(lblEmail);
		
		// Edit button
		editDetailsButton = new JButton("Edit Details");
		editDetailsButton.setFont(new Font("Calibri", Font.BOLD, 14));
		editDetailsButton.setBounds(88, 177, 118, 40);
		frame.getContentPane().add(editDetailsButton);
		
		// Log out button
		logOutButton = new JButton("Log Out");
		logOutButton.setFont(new Font("Calibri", Font.BOLD, 14));
		logOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                frame.dispose();
                LoginForm loginForm = new LoginForm();
                loginForm.frame.setTitle("JDBC Client Database - Enter Details");
                loginForm.frame.setVisible(true);
			}
		});
		logOutButton.setBounds(221, 177, 118, 40);
		frame.getContentPane().add(logOutButton);
	}
}
