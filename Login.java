package login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import util.JFrameSingleton;
import util.JavaMailUtil;

public class Login {
	//Create Frame
	JFrameSingleton f = JFrameSingleton.getInstance();
	
	public void createLoginPage() {
		//Create TextField
		final JTextField tf1 = new JTextField("Username");  
		tf1.setBounds(50,50, 150,20);
				
		//Create TextField
		final JTextField tf2 = new JTextField("Password");  
		tf2.setBounds(50,150, 150,20);
		
		//Create Button
		JButton b = new JButton("Click to Login");  
		b.setBounds(50,350,250,30);
		
		f.add(b);
		f.add(tf1);  
		f.add(tf2);	
	    f.setSize(400,500);  
	    f.setLayout(null);  
	    f.setVisible(true);   
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		//Create Action Listener for Button b
		b.addActionListener(
			new ActionListener(){  
				public void actionPerformed(ActionEvent e){  
					try{
						//Authenticate the username and password
						if(JavaMailUtil.authenticate(tf1.getText(), tf2.getText())){						
							tf1.setText(""); 
							tf2.setText("");
							b.setText("Logged In!");
							return;
						}else {							
							tf1.setText(""); 
							tf2.setText("");
							b.setText("Try Again!");
						}
					}catch(Exception ex){
						System.out.println("Could not login!");
						ex.printStackTrace();						
					}
				}  
			}
		);
		return;
					
	}
}