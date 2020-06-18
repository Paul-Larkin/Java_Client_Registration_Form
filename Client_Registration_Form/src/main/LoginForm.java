package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class LoginForm {

	JFrame frame;

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
	 * Create the application.
	 */
	public LoginForm() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// Register button
		JButton registerButton = new JButton("Register");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                frame.dispose();
				System.out.println("Hello");
                RegistrationForm registratioForm = new RegistrationForm();
                //registerForm.setTitle("Enter Details");
                registratioForm.frame.setVisible(true);
			}
		});
		registerButton.setBounds(225, 137, 96, 40);
		frame.getContentPane().add(registerButton);
		
		// Register button
		JButton signInButton = new JButton("Sign In");
		signInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                frame.dispose();
				System.out.println("Hello");
                RegistrationForm registratioForm = new RegistrationForm();
                //registerForm.setTitle("Enter Details");
                registratioForm.frame.setVisible(true);
			}
		});
		signInButton.setBounds(103, 137, 96, 40);
		frame.getContentPane().add(signInButton);
	}


}
