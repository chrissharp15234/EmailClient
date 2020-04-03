package controller;

import javax.swing.UnsupportedLookAndFeelException;

import login.Login;
import sendmail.NewEmail;

public class Controller {
	
	public static void main(String[] args) {
		
		//Create Login Page
		Login login = new Login();
		login.createLoginPage();
		
		System.out.println("Exited login.createLoginPage()");
		//If authenticated move to New Email
		NewEmail newEmail = new NewEmail();
		try {
			newEmail.sendEmail();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}