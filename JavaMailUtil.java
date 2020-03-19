package javatutorials.javamail;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class JavaMailUtil{
	public static void sendMail(String recipient, String emailSubject, String emailBody) throws Exception{
		System.out.println("Preparing to send email.");
		Properties properties = new Properties();
		
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		String myAccountEmail = "christopher.sharp.1985@gmail.com";
		String password = "Tata2014!";
		
		Session session = Session.getInstance(
			properties, new Authenticator(){
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(myAccountEmail,password);
				}
			}
		);
		
		Message message = prepareMessage(session, myAccountEmail, recipient, emailSubject, emailBody);			
		
		Transport.send(message);
		
		System.out.println("Sent email successfully!");
	}	
	
	private static Message prepareMessage(Session session,String myAccountEmail, String recipient, String emailSubject, String emailBody){
			try{
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(myAccountEmail));
				message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
				message.setSubject(emailSubject);
				message.setText(emailBody);
				return message;
			}
			catch(Exception e){
				System.out.println("Whoops! Looks like something went wrong in the prepareMessage!");
			}
			return null;
	}
}