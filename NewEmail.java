package sendmail;

import javax.swing.*;
import java.awt.event.*;  
import util.*;

public class NewEmail{  

	public void sendEmail() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException { 
	
		//Create Frame
		JFrameSingleton f = JFrameSingleton.getInstance();
		UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		
		//Create TextField
		final JTextField tf1 = new JTextField("Email");  
		tf1.setBounds(100,50, 150,20);  
		
		//Create TextField
		final JTextField tf2 = new JTextField("Subject");  
		tf2.setBounds(100,150, 150,20);  
		
		//Create TextField
		final JTextField tf3 = new JTextField("Body");  
		tf3.setBounds(100,250, 150,20);
		
		//Create Button
		JButton b = new JButton("Click to send email");  
		b.setBounds(100,350,250,30); 
		
		//Create Action Listener for Button b
		b.addActionListener(
			new ActionListener(){  
				public void actionPerformed(ActionEvent e){  
					try{
						JavaMailUtil.sendMail(tf1.getText(), tf2.getText(), tf3.getText());
						tf1.setText("");  //Need to add conditional to check if successful
						tf2.setText("");  //Need to add conditional to check if successful
						tf3.setText("");  //Need to add conditional to check if successful
						b.setText("Email Sent!");
						//b.setEnabled(false);
					}catch(Exception ex){
						System.out.println("Exception from JavaMailUtil!");
						ex.printStackTrace();
					}
				}  
			}
		);
	
    f.add(b);
	f.add(tf1);  
	f.add(tf2);
	f.add(tf3);
    f.setSize(400,500);  
    f.setLayout(null);  
    f.setVisible(true);   
	f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}  
}  