package test.newemail;

// Classical Java implementation of singleton  
// design pattern 

import javax.swing.*;
public class JFrameSingleton {
 
    private static JFrameSingleton myObj;
     
    static{
        myObj = new JFrame("New Email");
    }
     
    private JFrameSingleton(){
     
    }
     
    public static JFrameSingleton getInstance(){
        return myObj;
    }
     
    public void testMe(){
        System.out.println("Hey.... it is working!!!");
    }
     
    public static void main(String a[]){
        JFrameSingleton ms = getInstance();
        ms.testMe();
    }
}