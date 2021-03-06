package main;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class RegistrationForm {

	JFrame frame;
	
	private JLabel lblEnterDetails;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblEmail;
	private JLabel lblUsername;
	private JLabel lblPassword;
	
	private JTextField textFieldFirstName;
	private JTextField textFieldLastName;
	private JTextField textFieldEmail;
	private JTextField textFieldUsername;
	private JTextField textFieldPassword;
	
	private JButton submitButton;

	/**
	 * Constructor
	 */
	public RegistrationForm() {
		// Frame
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// Enter Details Label
		lblEnterDetails = new JLabel("Enter Details");
		lblEnterDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterDetails.setFont(new Font("Calibri", Font.BOLD, 34));
		lblEnterDetails.setBounds(103, 24, 229, 40);
		frame.getContentPane().add(lblEnterDetails);
		
		// Firstname label
		lblFirstName = new JLabel("First Name");
		lblFirstName.setHorizontalAlignment(SwingConstants.LEFT);
		lblFirstName.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblFirstName.setBounds(103, 68, 74, 20);
		frame.getContentPane().add(lblFirstName);
		
		// Lastname label
		lblLastName = new JLabel("Last Name");
		lblLastName.setHorizontalAlignment(SwingConstants.LEFT);
		lblLastName.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblLastName.setBounds(103, 92, 74, 20);
		frame.getContentPane().add(lblLastName);
		
		// Enter Details Label
		lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblEmail.setBounds(103, 116, 74, 20);
		frame.getContentPane().add(lblEmail);
		
		// Username label
		lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblUsername.setBounds(103, 140, 74, 20);
		frame.getContentPane().add(lblUsername);
		
		// Password label
		lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblPassword.setBounds(103, 164, 74, 20);
		frame.getContentPane().add(lblPassword);
		
		// Firstname text field
		textFieldFirstName = new JTextField();
		textFieldFirstName.setFont(new Font("Calibri", Font.PLAIN, 14));
		textFieldFirstName.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldFirstName.setBounds(197, 68, 135, 20);
		frame.getContentPane().add(textFieldFirstName);
		textFieldFirstName.setColumns(10);
		
		// Lastname text field
		textFieldLastName = new JTextField();
		textFieldLastName.setFont(new Font("Calibri", Font.PLAIN, 14));
		textFieldLastName.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldLastName.setColumns(10);
		textFieldLastName.setBounds(197, 92, 135, 20);
		frame.getContentPane().add(textFieldLastName);
		
		// Email text field
		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Calibri", Font.PLAIN, 14));
		textFieldEmail.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(197, 116, 135, 20);
		frame.getContentPane().add(textFieldEmail);
		
		// Username text field
		textFieldUsername = new JTextField();
		textFieldUsername.setFont(new Font("Calibri", Font.PLAIN, 14));
		textFieldUsername.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldUsername.setBounds(197, 140, 135, 20);
		frame.getContentPane().add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		// Password text field
		textFieldPassword = new JTextField();
		textFieldPassword.setFont(new Font("Calibri", Font.PLAIN, 14));
		textFieldPassword.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(197, 164, 135, 20);
		frame.getContentPane().add(textFieldPassword);
		
		// Register button
		submitButton = new JButton("Submit");
		submitButton.setFont(new Font("Calibri", Font.BOLD, 14));
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fname = textFieldFirstName.getText();
				String lname = textFieldLastName.getText();
				String email = textFieldEmail.getText();
				String uname = textFieldUsername.getText();
				String pword = textFieldPassword.getText();
				
				try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo?serverTimezone=UTC&useSSL=false", "root", "");
						PreparedStatement preparedStatement = connection.prepareStatement("INSERT into client (firstname, lastname, email, username, password) VALUES (?,?,?,?,?)");
						){
					
						preparedStatement.setString(1, fname);
						preparedStatement.setString(2, lname);
						preparedStatement.setString(3, email);
						preparedStatement.setString(4, uname);
						preparedStatement.setString(5, pword);

						int resultSet = preparedStatement.executeUpdate();
						if(resultSet >= 0) {
							ClientHomeScreen clientHomeScreen = new ClientHomeScreen(fname, lname, uname, email);
							clientHomeScreen.frame.setTitle("JDBC Client Database - " + uname);
							clientHomeScreen.frame.setVisible(true);
							JOptionPane.showMessageDialog(null, "Account Registered", "Success", 1);
							
						}
					
					} catch (SQLException sqlEx) {
						sqlEx.printStackTrace();
	                }
			}
		});
		submitButton.setBounds(152, 197, 96, 40);
		frame.getContentPane().add(submitButton);
	}
}
