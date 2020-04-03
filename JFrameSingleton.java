package util;

// Classical Java implementation of singleton  
// design pattern 

import javax.swing.*;
public class JFrameSingleton extends JFrame{
 
    /**
	 * This class is a singleton and contains a serialVersionUID in case of desired serialization.
	 */
	private static final long serialVersionUID = 1L;
	private static final JFrame myObj =  new JFrameSingleton();	
     
    private JFrameSingleton(){
    	
    }
     
    public static JFrameSingleton getInstance(){
        return (JFrameSingleton) myObj;
    }     
}