package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.SystemColor;

public class LoginForm {

	JFrame frame;
	
	private JLabel lblWelcome;
	private JLabel lblUsername;
	private JLabel lblPassword;
	
	private JTextField textFieldUsername;
	private JTextField textFieldPassword;
	
	private JButton signInButton;
	private JButton registerButton;
	
	static String username;
	static String password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm window = new LoginForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor
	 */
	public LoginForm() {
		// Frame 
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.menu);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("JDBC Client Database - Welcome");
		
		// Welcome label
		lblWelcome = new JLabel("WELCOME");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Calibri", Font.BOLD, 34));
		lblWelcome.setBounds(103, 45, 218, 49);
		frame.getContentPane().add(lblWelcome);
		
		// Username label
		lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblUsername.setBounds(103, 105, 74, 20);
		frame.getContentPane().add(lblUsername);
		
		// Password label
		lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblPassword.setBounds(103, 126, 74, 20);
		frame.getContentPane().add(lblPassword);
		
		// Username text field
		textFieldUsername = new JTextField();
		textFieldUsername.setFont(new Font("Calibri", Font.PLAIN, 14));
		textFieldUsername.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldUsername.setBounds(186, 105, 135, 20);
		frame.getContentPane().add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		// Password text field
		textFieldPassword = new JTextField();
		textFieldPassword.setFont(new Font("Calibri", Font.PLAIN, 14));
		textFieldPassword.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(186, 126, 135, 20);
		frame.getContentPane().add(textFieldPassword);
		
		// Sign In button
		signInButton = new JButton("Sign In");
		signInButton.setFont(new Font("Calibri", Font.BOLD, 14));
		signInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Get the input text as Strings
				username = textFieldUsername.getText();
				password = textFieldPassword.getText();
				
				// Connection
				try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo?serverTimezone=UTC&useSSL=false", "root", "");
					PreparedStatement preparedStatement = connection.prepareStatement("Select * from client where username=? and password=?");){
					
					preparedStatement.setString(1, username);
					preparedStatement.setString(2, password);
					ResultSet resultSet = preparedStatement.executeQuery();
					
					if(resultSet.next()) {
						System.out.println("Success");
						frame.dispose();
						String fname = resultSet.getString("firstname");
						String lname = resultSet.getString("lastname");
						String uname = resultSet.getString("username");
						String email = resultSet.getString("email");
						ClientHomeScreen clientHomeScreen = new ClientHomeScreen(fname, lname, uname, email);
						clientHomeScreen.frame.setTitle("JDBC Client Database - " + username);
						clientHomeScreen.frame.setVisible(true);
						JOptionPane.showMessageDialog(null, "Success - Welcome " + username);
					} else {
						JOptionPane.showMessageDialog(null, "Wrong Username & Password");
					}
				} catch (SQLException sqlEx) {
					sqlEx.printStackTrace();
                }
			}
		});		
		signInButton.setBounds(103, 157, 96, 40);
		frame.getContentPane().add(signInButton);
		
		// Register button
		registerButton = new JButton("Register");
		registerButton.setFont(new Font("Calibri", Font.BOLD, 14));
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                frame.dispose();
                RegistrationForm registrationForm = new RegistrationForm();
                registrationForm.frame.setTitle("JDBC Client Database - Enter Details");
                registrationForm.frame.setVisible(true);
			}
		});
		registerButton.setBounds(225, 157, 96, 40);
		frame.getContentPane().add(registerButton);
	}
}
