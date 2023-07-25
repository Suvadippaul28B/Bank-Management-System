
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    
    JButton deposit,withdrawl,fastcash,exit,pinchange,balance,ministatement;
    String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon (ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 800, 600);
        add(image);
        
        JLabel text=new JLabel("Please select amount");
        text.setBounds(200, 170, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(text);
        
        deposit=new JButton("Rs 100");
        deposit.setBounds(150, 270, 100, 30);
        deposit.setForeground(Color.BLACK);
        deposit.setFont(new Font("Raleway",Font.BOLD,12));
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl=new JButton("Rs 500");
        withdrawl.setBounds(300, 270, 150, 30);
        withdrawl.setForeground(Color.BLACK);
        withdrawl.setFont(new Font("Raleway",Font.BOLD,12));
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash=new JButton("RS 1000");
        fastcash.setBounds(150, 305, 100, 30);
        fastcash.setForeground(Color.BLACK);
        fastcash.setFont(new Font("Raleway",Font.BOLD,12));
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement=new JButton("RS 2000");
        ministatement.setBounds(300, 301, 150, 30);
        ministatement.setForeground(Color.BLACK);
        ministatement.setFont(new Font("Raleway",Font.BOLD,12));
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange=new JButton("RS 5000");
        pinchange.setBounds(150, 340, 100, 30);
        pinchange.setForeground(Color.BLACK);
        pinchange.setFont(new Font("Raleway",Font.BOLD,12));
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balance=new JButton("RS 10000");
        balance.setBounds(300, 330, 150, 30);
        balance.setForeground(Color.BLACK);
        balance.setFont(new Font("Raleway",Font.BOLD,12));
        balance.addActionListener(this);
        image.add(balance);
        
        exit=new JButton("BACK");
        exit.setBounds(350, 360, 100, 30);
        exit.setForeground(Color.BLACK);
        exit.setFont(new Font("Raleway",Font.BOLD,12));
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(800,800);
        setLocation(300,0);
        //setUndecorated(true);
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== exit){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }else 
        {
           String amount=((JButton)ae.getSource()).getText().substring(3);
           con c=new con();
           try{
               ResultSet rs=c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
               int balance=0;
               while(rs.next()){
                   if(rs.getString("type").equals("Deposit")){
                       balance+=Integer.parseInt(rs.getString("amount"));
                   }
                   else{
                       balance-=Integer.parseInt(rs.getString("amount"));
                   }
               }
               if(ae.getSource()!= exit && balance <Integer.parseInt(amount)){
                   JOptionPane.showMessageDialog(null,"Insufficient Balance");
                   return;
               }
               Date date=new Date();
               String query="insert into bank values ('"+pinnumber+"','"+date+"','withdrawl','"+amount+"')";
               c.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "Rs "+amount+"Debit Successfully");
               setVisible(false);
               new Transaction(pinnumber).setVisible(true);
           }catch(Exception e){
               System.out.println(e);
           }
        }
        
    }
    
    public static void main(String args[]){
        
        new FastCash("");
        
    }
    
}
