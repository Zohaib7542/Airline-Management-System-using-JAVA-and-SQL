
package airlinemanagementsystem;
import javax.swing.*; //for JFrame package we import this.
import java.awt.*;
import java.awt.event.*; //used to implement Action Listener in the where we want to add event.(save button) for working.
import java.sql.*;
import java.util.*; //math , random

//now we need to make a frame
public class BoardingPass extends JFrame implements ActionListener{
    
    // all the text fields we need to declare globally
    JTextField tfpnr;
    JLabel tfname,tfnationality,lblsrc,lbldest,labelfname,labelfcode,labeldate;
    JButton fetchButton;

   
    public BoardingPass(){
        getContentPane().setBackground(Color.WHITE); //awt package contains color class
        setLayout(null);
        
        //now make heading for frame
        
        JLabel heading = new JLabel("AIR INDIA");
        heading.setBounds(380,10,450,35);
        heading.setFont(new Font("Tahoma",Font.PLAIN,32));
        heading.setForeground(Color.RED);
        add(heading);
        
        JLabel subheading = new JLabel("BOARDING PASS");
        subheading.setBounds(360,60,300,30);
        subheading.setFont(new Font("Tahoma",Font.PLAIN,24));
        subheading.setForeground(Color.RED);
        add(subheading);
           
         JLabel lbladhaar = new JLabel("PNR DETAILS");
        lbladhaar.setBounds(60,100,150,50);
        lbladhaar.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbladhaar.setForeground(Color.BLACK);
        add(lbladhaar);
        
        tfpnr= new JTextField();
        tfpnr.setBounds(220,110,150,25);
        add(tfpnr);
        
        fetchButton = new JButton("Enter"); //fetch the data from database
        fetchButton.setBackground(Color.GREEN);
        fetchButton.setForeground(Color.BLUE);
        fetchButton.setBounds(380,110,120,25);
        fetchButton.addActionListener(this);
        
        add(fetchButton);
        
        
        
        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60,140,150,50);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblname.setForeground(Color.BLACK);
        add(lblname);
        
//        JTextField tfname = new JTextField();
        tfname = new JLabel();  //globally i decare the JTextField
        tfname.setBounds(220,152,150,25);
        add(tfname);
        
         JLabel lblnationality = new JLabel("NATIONALITY");
        lblnationality.setBounds(60,180,150,50);
        lblnationality.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblnationality.setForeground(Color.BLACK);
        add(lblnationality);
        
        tfnationality= new JLabel();
        tfnationality.setBounds(220,194,150,25);
        add(tfnationality);
     
        
        JLabel lbladdress = new JLabel("SRC");
        lbladdress.setBounds(60,215,150,50);
        lbladdress.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbladdress.setForeground(Color.BLACK);
        add(lbladdress);
        
        lblsrc = new JLabel();
        lblsrc.setBounds(220,230,150,25);
        add(lblsrc);
        
        JLabel lblgender = new JLabel("DEST");
        lblgender.setBounds(380,215,150,50);
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblgender.setForeground(Color.BLACK);
        add(lblgender);
        
        lbldest = new JLabel();
        lbldest.setBounds(500,215,150,50);
        add(lbldest);
        
        
        JLabel lblfname = new JLabel("Flight Name");
        lblfname.setBounds(60,270,150,25);
        lblfname.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblfname.setForeground(Color.BLACK);
        add(lblfname);
        
        labelfname = new JLabel();
        labelfname.setBounds(220,270,150,25);
        add(labelfname);
        
        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode .setBounds(380,270,150,25);
        lblfcode .setFont(new Font("Tahoma",Font.PLAIN,16));
        lblfcode .setForeground(Color.BLACK);
        add(lblfcode );
        
        labelfcode = new JLabel();
        labelfcode.setBounds(500,270,150,25);
        add(labelfcode);
        
        
        
        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60,300,150,50);
        lbldate.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbldate.setForeground(Color.BLACK);
        add(lbldate);

        

        labeldate= new JLabel();
        labeldate.setBounds(220,315,150,25);
        add(labeldate);

        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/airindia.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 230, Image.SCALE_DEFAULT);  // Limiting the size of image
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(600,0,300,300);
        add(lblimage);
        
        
        setSize(1000,450);
        setLocation(200,200);
        setVisible(true); // it makes the frame visible in the screen
        
    }
    
    public void actionPerformed(ActionEvent ae){      //we are overriding the method.
        if(ae.getSource()== fetchButton){
        String pnr = tfpnr.getText();
       
        
        try{
            conn c = new conn();
            
            String query = "select * from reservation where PNR = '"+pnr+"'";
            
            ResultSet rs = c.s.executeQuery(query); //it fetch and give it to user.
            
             if(rs.next()){
                tfname.setText(rs.getString("name"));
                tfnationality.setText(rs.getString("nationality"));
                lblsrc.setText(rs.getString("src"));
                lbldest.setText(rs.getString("des"));
                labelfname.setText(rs.getString("flightname"));
                labelfcode.setText(rs.getString("flightcode"));
                labeldate.setText(rs.getString("date"));
                
                
                
                
            }else{
                JOptionPane.showMessageDialog(null,"Please enter correct PNR");
            }
        }catch(Exception e){
            e.printStackTrace();
    }
        }
        
        
    }
    
        
    public static void main(String[] args){
        
        new BoardingPass();
    }
    
}

