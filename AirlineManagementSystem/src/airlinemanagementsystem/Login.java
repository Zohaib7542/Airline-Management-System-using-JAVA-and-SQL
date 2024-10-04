
package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*; //colors
import java.awt.event.*; //ActionListener
import java.sql.*; //Resultset query


// any keyword which has J in front comes from swing pakage.
public class Login extends JFrame implements ActionListener{
    JButton reset,submit,close; //globally declared buttons. we can use this buttons to another function.
    JTextField tfusername;
    JPasswordField tfpassword;
    public Login() {
       
        //setting the frame
        getContentPane().setBackground(Color.WHITE);//comes in awt packages
       
        
        setLayout(null);
        
       
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(20,20,100,20);//left,top,length of Username,height.
        add(lblusername);//we have to pass this function to show the Username on screen.
        
        //setting the text field in front of username.
        
        tfusername = new JTextField();
        tfusername.setBounds(130,20,200,20);
        add(tfusername);
        
        //adding password 
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(20,60,100,20);
        add(lblpassword);
        //password field
        tfpassword = new JPasswordField();
        tfpassword.setBounds(130,60,200,20);
        add(tfpassword);
        
        //making buttons
        reset = new JButton("Reset");
        reset.setBounds(40,120,120,20);
        reset.addActionListener(this);
        add(reset);
        
        submit = new JButton("Submit");
        submit.setBounds(190,120,120,20);
        submit.addActionListener(this); //to perform some actions on this button.
        add(submit);
        
        close = new JButton("Close");
        close.setBounds(120,160,120,20);
        close.addActionListener(this);
        add(close);
        
        
        setSize(400,250);
        setLocation(500,250);//location is center .
        setVisible(true); //now we can see the frame
        
    }
    // it extends eventListener so we have to override this method in this class.
    
    public void actionPerformed(ActionEvent ae){
        //action performed by buttons
        
        //all this action we have to declare the buttons and textfields globally
        if(ae.getSource() == submit){
            //values filled by user now we have to access the value.
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
            try{
                //connecting to conn.java
                conn c = new conn();
                String query = "select * from login where username ='"+username+"' and password = '"+password+"'";
                ResultSet rs = c.s.executeQuery(query);
                
                if(rs.next()){          // it checks the user is valid or not
                    System.out.println("Valid");
                    new Home(); //it render the home class file
                    setVisible(false);
                    
                    
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid username or Password");
                    setVisible(false);
                    
                }
                
            }catch (Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource() == close){
            setVisible(false);
            
        }else if(ae.getSource() == reset){
            tfusername.setText("");
            tfpassword.setText("");
            
        }
        
    }
    public static void main(String[] args){ 
        new Login();
        
     
}
}
