
package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class FlightInfo  extends JFrame{
    public FlightInfo(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JTable table = new JTable();
        
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from flight");
            //add rs2xml.jar in library
            //import net.proteanit.sql.DbUtils;
            table.setModel(DbUtils.resultSetToTableModel(rs)); //this makes a table
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
        table.setShowGrid(true); // Enable grid lines
        table.setGridColor(Color.ORANGE); // Set grid line color
       
       
        
        JScrollPane jsp = new JScrollPane(table);  //scrollbar
        jsp.setBounds(0,0,800,500);
        add(jsp);
        
        
        
        setSize(800,500);
        setLocation(400,200);
        setVisible(true);
        
    }
    
    
    public static void main(String[] args){
        new FlightInfo();
    }
    
}
