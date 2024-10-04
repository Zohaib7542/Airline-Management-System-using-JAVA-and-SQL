
package airlinemanagementsystem;
import javax.swing.*; //for JFrame package we import this.
import java.awt.*;
import java.awt.event.*; //used to implement Action Listener in the where we want to add event.(save button) for working.

//now we need to make a frame
public class AddCustomer extends JFrame implements ActionListener{
    
    // all the text fields we need to declare globally
    JTextField tfname,tfphone,tfadhaar,tfnationality,tfaddress;
    JRadioButton rbmale,rbfemale;
    public AddCustomer(){
        getContentPane().setBackground(Color.WHITE); //awt package contains color class
        setLayout(null);
        
        //now make heading for frame
        
        JLabel heading = new JLabel("ADD CUSTOMER DETAILS");
        heading.setBounds(280,20,500,35);
        heading.setFont(new Font("Tahoma",Font.PLAIN,32));
        heading.setForeground(Color.GRAY);
        add(heading);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60,80,150,50);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblname.setForeground(Color.BLACK);
        add(lblname);
        
//        JTextField tfname = new JTextField();
        tfname = new JTextField();  //globally i decare the JTextField
        tfname.setBounds(220,90,150,25);
        add(tfname);
        
         JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(60,130,150,50);
        lblnationality.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblnationality.setForeground(Color.BLACK);
        add(lblnationality);
        
        tfnationality= new JTextField();
        tfnationality.setBounds(220,140,150,25);
        add(tfnationality);
        
         JLabel lbladhaar = new JLabel("Adhaar");
        lbladhaar.setBounds(60,180,150,50);
        lbladhaar.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbladhaar.setForeground(Color.BLACK);
        add(lbladhaar);
        
       tfadhaar= new JTextField();
       tfadhaar.setBounds(220,190,150,25);
        add(tfadhaar);
        
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60,230,150,50);
        lbladdress.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbladdress.setForeground(Color.BLACK);
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(220,240,150,25);
        add(tfaddress);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60,280,150,50);
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblgender.setForeground(Color.BLACK);
        add(lblgender);
        
        ButtonGroup gendergroup = new ButtonGroup();//both radio button can not select.
        
//        JRadioButton rbmale = new JRadioButton("M");
        rbmale = new JRadioButton("M"); //we add global variable
        
        rbmale.setBounds(230,290,70,25);
        add(rbmale);
        
         rbfemale = new JRadioButton("F");
        rbfemale.setBounds(320,290,70,25);
        add(rbfemale);
        
        gendergroup.add(rbmale);
        gendergroup.add(rbfemale);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(60,330,150,50);
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblphone.setForeground(Color.BLACK);
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(220,340,150,25);
        add(tfphone);
        
        JButton save = new JButton("Save");
        save.setBackground(Color.BLACK);
        save.setForeground(Color.RED);
        save.setBounds(220,380,150,30);
        save.addActionListener(this);
        add(save);
        
        //image
        
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/emp.png"));
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(450,80,280,400);
        add(lblimage);
        
        setSize(900,600);
        setLocation(300,150);
        setVisible(true); // it makes the frame visible in the screen
        
    }
    
    public void actionPerformed(ActionEvent ae){      //we are overriding the method.
        //taking the values
        String name = tfname.getText();
        String nationality = tfnationality.getText();
        String phone = tfphone.getText();
        String address = tfaddress.getText();
        String adhaar = tfadhaar.getText();
        
        String gender = null;
        if(rbmale.isSelected()){
            gender = "Male";
        }else{
            gender = "Female";
        }
        
        try{
            conn c = new conn();
            
            String query = "insert into passenger values('"+name+"','"+nationality+"','"+phone+"','"+address+"','"+adhaar+"','"+gender+"')";
            
            c.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null,"Customer Details added successfully");
            
            setVisible(false);
            
        }catch(Exception e){
            e.printStackTrace();
    }
    }
    
        
    public static void main(String[] args){
        
        new AddCustomer();
    }
    
}
