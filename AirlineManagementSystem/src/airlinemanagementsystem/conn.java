package airlinemanagementsystem;
import java.sql.*; //fro connection and statement string.
// now we are connecting to the database.
public class conn {
    Connection c;
    Statement s;
    public conn(){
        try{
            //connecting to jdbc we have some steps:
            // 1. registering the driver.
            // 2. create the connection string.
            // 3. create statements.
            // 4. run mysql query
            Class.forName("com.mysql.cj.jdbc.Driver"); //1. registering the driver.
            //this will be found on jar file in libraries.
            c = DriverManager.getConnection("jdbc:mysql:///airlinemanagementsystem","root","Zohaibakhtar1"); //2. creating connecting string.
            s = c.createStatement(); // 3. create statements.
            // this creating the statement of c.
               
        }catch(Exception e){
            e.printStackTrace();
            
        }
        
        
        
        }
            
        
    
}
