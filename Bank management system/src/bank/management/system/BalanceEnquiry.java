
package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
    JButton back;
    String pinnumber;
    
    BalanceEnquiry(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon (ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 800, 600);
        add(image);
        
        back=new JButton("Back");
        back.setBounds(330, 360, 100, 30);
        back.addActionListener(this);
        image.add(back);
        
        con c=new con();
          int balance=0;
           try{
               ResultSet rs=c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
               
               while(rs.next()){
                   if(rs.getString("type").equals("Deposit")){
                       balance+=Integer.parseInt(rs.getString("amount"));
                   }
                   else{
                       balance-=Integer.parseInt(rs.getString("amount"));
              }}}catch(Exception e)
                 {
                   System.out.println(e);
                 }
            JLabel text=new JLabel("Your current account balance is Rs "+balance);
            text.setForeground(Color.WHITE);
            text.setBounds(170, 200, 400, 30);
            image.add(text);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }
    
    
    public static void main (String args[]){
        new BalanceEnquiry("");
    }
    
}
