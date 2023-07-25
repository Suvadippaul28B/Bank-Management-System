
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener{
    
    JButton deposit,withdrawl,fastcash,exit,pinchange,balance,ministatement;
    String pinnumber;
    Transaction(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon (ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 800, 600);
        add(image);
        
        JLabel text=new JLabel("Please select your Tranjection");
        text.setBounds(200, 170, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(text);
        
        deposit=new JButton("Deposit");
        deposit.setBounds(150, 270, 100, 30);
        deposit.setForeground(Color.BLACK);
        deposit.setFont(new Font("Raleway",Font.BOLD,12));
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl=new JButton("Cash Withdrawl");
        withdrawl.setBounds(300, 270, 150, 30);
        withdrawl.setForeground(Color.BLACK);
        withdrawl.setFont(new Font("Raleway",Font.BOLD,12));
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash=new JButton("FastCash");
        fastcash.setBounds(150, 305, 100, 30);
        fastcash.setForeground(Color.BLACK);
        fastcash.setFont(new Font("Raleway",Font.BOLD,12));
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement=new JButton("Mini Statement");
        ministatement.setBounds(300, 301, 150, 30);
        ministatement.setForeground(Color.BLACK);
        ministatement.setFont(new Font("Raleway",Font.BOLD,12));
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange=new JButton("Pin change");
        pinchange.setBounds(150, 340, 100, 30);
        pinchange.setForeground(Color.BLACK);
        pinchange.setFont(new Font("Raleway",Font.BOLD,12));
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balance=new JButton("Balance Enquiry");
        balance.setBounds(300, 330, 150, 30);
        balance.setForeground(Color.BLACK);
        balance.setFont(new Font("Raleway",Font.BOLD,12));
        balance.addActionListener(this);
        image.add(balance);
        
        exit=new JButton("Exit");
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
            System.exit(0);
        }else if(ae.getSource()== deposit)
        {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(ae.getSource()==withdrawl)
        {
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }else if(ae.getSource()==fastcash)
        {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if(ae.getSource()==pinchange)
        {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }else if(ae.getSource()==balance)
        {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if(ae.getSource()==ministatement)
        {
            
            new MiniStatement(pinnumber).setVisible(true);
        }
        
    }
    
    public static void main(String args[]){
        
        new Transaction("");
        
    }
    
}
