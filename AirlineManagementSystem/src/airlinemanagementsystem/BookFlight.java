
package airlinemanagementsystem;
import javax.swing.*; //for JFrame package we import this.
import java.awt.*;
import java.awt.event.*; //used to implement Action Listener in the where we want to add event.(save button) for working.
import java.sql.*;
import com.toedter.calendar.JDateChooser;  //to make a calender
import java.util.*; //math , random

//now we need to make a frame
public class BookFlight extends JFrame implements ActionListener{
    
    // all the text fields we need to declare globally
    JTextField tfadhaar,dcdate;
    JLabel tfname,tfnationality,tfaddress,labelgender,labelfname,labelfcode;
    JButton bookflight,fetchButton,flight;
    Choice source,destination;
//    JDateChooser dcdate;
   
    public BookFlight(){
        getContentPane().setBackground(Color.WHITE); //awt package contains color class
        setLayout(null);
        
        //now make heading for frame
        
        JLabel heading = new JLabel("Book Flight");
        heading.setBounds(420,20,500,35);
        heading.setFont(new Font("Tahoma",Font.PLAIN,32));
        heading.setForeground(Color.RED);
        add(heading);
           
         JLabel lbladhaar = new JLabel("Adhaar");
        lbladhaar.setBounds(60,80,150,50);
        lbladhaar.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbladhaar.setForeground(Color.BLACK);
        add(lbladhaar);
        
        tfadhaar= new JTextField();
        tfadhaar.setBounds(220,90,150,25);
        add(tfadhaar);
        
        fetchButton = new JButton("Fetch User"); //fetch the data from database
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
        
         JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(60,180,150,50);
        lblnationality.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblnationality.setForeground(Color.BLACK);
        add(lblnationality);
        
        tfnationality= new JLabel();
        tfnationality.setBounds(220,194,150,25);
        add(tfnationality);
     
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60,230,150,50);
        lbladdress.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbladdress.setForeground(Color.BLACK);
        add(lbladdress);
        
        tfaddress = new JLabel();
        tfaddress.setBounds(220,242,150,25);
        add(tfaddress);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60,280,150,50);
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblgender.setForeground(Color.BLACK);
        add(lblgender);
        
        labelgender = new JLabel();
        labelgender.setBounds(220,280,150,50);
        add(labelgender);
        
        
       JLabel lblsource = new JLabel("Source");
        lblsource.setBounds(60,330,150,50);
        lblsource.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblsource.setForeground(Color.BLACK);
        add(lblsource);
        
        source = new Choice();
        source.setBounds(220,341,150,25);
        add(source);
        
        JLabel lbldest = new JLabel("Destination");
        lbldest.setBounds(60,380,150,50);
        lbldest.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbldest.setForeground(Color.BLACK);
        add(lbldest);
        
        destination = new Choice();
        destination.setBounds(220,400,150,25);
        add(destination);
        
        //call the database
        try{
            conn c = new conn();
            String query= "select * from flight";
            ResultSet rs = c.s.executeQuery(query);  //we need to execute the query store in ResultSet-> it comes from sql package.
            while(rs.next()) {  // it jumps row by row to select
                source.add(rs.getString("source"));
                destination.add(rs.getString("destination"));
            }
            
            
        }catch (Exception e){
            e.printStackTrace();
        }
        
    
        
        flight = new JButton("Fetch Flights");
        flight.setBackground(Color.BLACK);
        flight.setForeground(Color.BLUE);
        flight.setBounds(380,397,120,30);
        flight.addActionListener(this);
        add(flight);
       
        //we can fetch flight name and fligt code from button fetch flight.
        JLabel lblfname = new JLabel("Flight Name");
        lblfname.setBounds(60,430,150,50);
        lblfname.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblfname.setForeground(Color.BLACK);
        add(lblfname);
        
        labelfname = new JLabel();
        labelfname.setBounds(220,440,150,25);
        add(labelfname);
        
        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode .setBounds(60,480,150,50);
        lblfcode .setFont(new Font("Tahoma",Font.PLAIN,16));
        lblfcode .setForeground(Color.BLACK);
        add(lblfcode );
        
        labelfcode = new JLabel();
        labelfcode.setBounds(220,490,150,25);
        add(labelfcode);
        
        
        
        JLabel lbldate = new JLabel("Date of Travel");
        lbldate.setBounds(60,530,150,50);
        lbldate.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbldate.setForeground(Color.BLACK);
        add(lbldate );
        // we add the calender in the date of travel by downloading jar file jcalender and 
        
//        dcdate = new JDateChooser();
//        dcdate.setBounds(220,540,150,25);
//        add(dcdate);
        

        dcdate= new JTextField();
        dcdate.setBounds(220,540,150,25);
        add(dcdate);
//        //image
//        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/details.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 320, Image.SCALE_DEFAULT);  // Limiting the size of image
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(550,80,500,410);
        add(lblimage);
        
         
        bookflight = new JButton("Book Flight");
        bookflight.setBackground(Color.BLACK);
        bookflight.setForeground(Color.BLUE);
        bookflight.setBounds(220,580,150,30);
        bookflight.addActionListener(this);
        add(bookflight);
        
        setSize(1100,800);
        setLocation(180,50);
        setVisible(true); // it makes the frame visible in the screen
        
    }
    
    public void actionPerformed(ActionEvent ae){      //we are overriding the method.
        if(ae.getSource()== fetchButton){
        //taking the values
        String adhaar = tfadhaar.getText();
       
        
        try{
            conn c = new conn();
            
            String query = "select * from passenger where adhaar = '"+adhaar+"'";
            
            ResultSet rs = c.s.executeQuery(query); //it fetch and give it to user.
            
            if(rs.next()){
                tfname.setText(rs.getString("name"));
                tfnationality.setText(rs.getString("nationality"));
                tfaddress.setText(rs.getString("address"));
                labelgender.setText(rs.getString("gender"));
                
            }else{
                JOptionPane.showMessageDialog(null,"Please enter correct adhaar");
            }
           
        }catch(Exception e){
            e.printStackTrace();
    }
        }else if(ae.getSource()== flight){
            String src = source.getSelectedItem();
            String dest = destination.getSelectedItem();
        
        try{
            conn c = new conn();
            
            String query = "select * from flight where source = '"+src+"'and destination = '"+dest+"'";
            
            ResultSet rs = c.s.executeQuery(query); //it fetch and give it to user.
            
            if(rs.next()){
                labelfname.setText(rs.getString("f_name"));
                labelfcode.setText(rs.getString("f_code"));
                tfaddress.setText(rs.getString("address"));
                labelgender.setText(rs.getString("gender"));
                
            }else{
                JOptionPane.showMessageDialog(null,"No Flights Found");
            }
           
        }catch(Exception e){
            e.printStackTrace();
    }
        }else {
            // Book flight button
            Random random = new Random();
            String adhaar = tfadhaar.getText();
            String name = tfname.getText();
            String nationality = tfnationality.getText();
            String flighname = labelfname.getText();
            String flightcode = labelfcode.getText();
            String src = source.getSelectedItem(); // we need to select and save it to database
            String des = destination.getSelectedItem();
            String date = dcdate.getText();
//            String date = ((JTextField)dcdate.getDateEditor().getUiComponent()).getText();
            try{
            conn c = new conn();
            
            String query = "insert into reservation values('PNR-"+random.nextInt(1000000)+"','TIC-"+random.nextInt(10000)+"','"+adhaar+"','"+name+"','"+nationality+"','"+flighname+"','"+flightcode+"','"+src+"','"+des+"','"+date+"')";
            
            c.s.executeUpdate(query); 
            
            
                JOptionPane.showMessageDialog(null,"Ticket Booked Successfully");
                setVisible(false);
            
           
        }catch(Exception e){
            e.printStackTrace();
    }
           
            
            
            
        }
        
        
    }
    
        
    public static void main(String[] args){
        
        new BookFlight();
    }
    
}
