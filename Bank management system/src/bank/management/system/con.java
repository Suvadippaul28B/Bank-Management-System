
package bank.management.system;

 import java.sql.*;

public class con {
    Connection c;
    Statement s;
    public con()
    {
        try{
           
           c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","suvadip123");
           s=c.createStatement();
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
}
