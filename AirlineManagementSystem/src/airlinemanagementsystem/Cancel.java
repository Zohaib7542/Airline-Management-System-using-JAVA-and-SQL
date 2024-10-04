
package airlinemanagementsystem;
import javax.swing.*; //for JFrame package we import this.
import java.awt.*;
import java.awt.event.*; //used to implement Action Listener in the where we want to add event.(save button) for working.
import java.sql.*;
import java.util.*; //math , random

//now we need to make a frame
public class Cancel extends JFrame implements ActionListener{
    
    // all the text fields we need to declare globally
    JTextField tfpnr;
    JLabel tfname,cancellationno,lblfcode,lbldateoftravel;
    JButton fetchButton,flight;
  
//    JDateChooser dcdate;
   
    public Cancel(){
        getContentPane().setBackground(Color.WHITE); //awt package contains color class
        setLayout(null);
        
        Random random = new Random();
        
        //now make heading for frame
        
        JLabel heading = new JLabel("CANCELLATION");
        heading.setBounds(300,20,250,35);
        heading.setFont(new Font("Tahoma",Font.PLAIN,32));
        add(heading);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/cancel.jpg"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT); //scaling the image.
        ImageIcon i3 = new ImageIcon(i2);//now we have to convert the image to imageIcon bcz we have to set the image in JLabel , Image object cant set directly in JLabel.
        JLabel image = new JLabel(i3);
        image.setBounds(470,130,250,250);
        add(image);
        
           
         JLabel lblpnr = new JLabel("PNR Number");
        lblpnr.setBounds(60,80,150,50);
        lblpnr.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblpnr.setForeground(Color.BLACK);
        add(lblpnr);
        
        tfpnr= new JTextField();
        tfpnr.setBounds(220,90,150,25);
        add(tfpnr);
        
        fetchButton = new JButton("Show Details"); //fetch the data from database
        fetchButton.setBackground(Color.GREEN);
        fetchButton.setForeground(Color.BLUE);
        fetchButton.setBounds(380,90,120,25);
        fetchButton.addActionListener(this);
        
        add(fetchButton);
        
        
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60,130,150,50);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblname.setForeground(Color.BLACK);
        add(lblname);
        
//        JTextField tfname = new JTextField();
        tfname = new JLabel();  //globally i decare the JTextField
        tfname.setBounds(220,142,150,25);
        add(tfname);
        
         JLabel cn = new JLabel("Cancellation No");
        cn.setBounds(60,180,150,50);
        cn.setFont(new Font("Tahoma",Font.PLAIN,16));
        cn.setForeground(Color.BLACK);
        add(cn);
        
        cancellationno= new JLabel(""+random.nextInt(1000000)); // JLabel Only take string so we concate "" to work.
        cancellationno.setBounds(220,194,150,25);
        add(cancellationno);
     
        
        JLabel lbladdress = new JLabel("Flight Code");
        lbladdress.setBounds(60,230,150,50);
        lbladdress.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbladdress.setForeground(Color.BLACK);
        add(lbladdress);
        
        lblfcode = new JLabel();
        lblfcode.setBounds(220,242,150,25);
        add(lblfcode);
        
        JLabel lblgender = new JLabel("Date");
        lblgender.setBounds(60,280,150,50);
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblgender.setForeground(Color.BLACK);
        add(lblgender);
        
        lbldateoftravel = new JLabel();
        lbldateoftravel.setBounds(220,280,150,50);
        add(lbldateoftravel);
  
        flight = new JButton("Cancel");
        flight.setBackground(Color.BLACK);
        flight.setForeground(Color.BLUE);
        flight.setBounds(220,330,120,40);
        flight.addActionListener(this);
       
        add(flight);
        
       
        setSize(800,450);
        setLocation(300,200);
        setVisible(true); // it makes the frame visible in the screen
        
    }
    
    public void actionPerformed(ActionEvent ae){      //we are overriding the method.
        if(ae.getSource()== fetchButton){
        //taking the values
        String pnr = tfpnr.getText();
       
        
        try{
            conn c = new conn();
            
            String query = "select * from reservation where PNR = '"+pnr+"'";
            
            ResultSet rs = c.s.executeQuery(query); //it fetch and give it to user.
            
            if(rs.next()){
                tfname.setText(rs.getString("name"));
                lblfcode.setText(rs.getString("flightcode"));
                lbldateoftravel.setText(rs.getString("date"));
                
                
            }else{
                JOptionPane.showMessageDialog(null,"Please enter correct PNR");
            }
           
        }catch(Exception e){
            e.printStackTrace();
    }
        }else if(ae.getSource()== flight){
            String name = tfname.getText();
            String pnr = tfpnr.getText();
            String cancelno = cancellationno.getText();
            String fcode = lblfcode.getText();
            String date = lbldateoftravel.getText();
        
        try{
            conn c = new conn();
            
            String query = "insert into cancel values('"+pnr+"','"+name+"','"+cancelno+"','"+fcode+"','"+date+"')";
            
            c.s.executeUpdate(query); //it update the data into database.
            c.s.executeUpdate("delete from reservation where PNR = '"+pnr+"'");
            
            JOptionPane.showMessageDialog(null,"Ticket Cancelled");
            setVisible(false);
            
           
        }catch(Exception e){
            e.printStackTrace();
        }
    }
        
}
    
        
    public static void main(String[] args){
        
        new Cancel();
    }
    
}

