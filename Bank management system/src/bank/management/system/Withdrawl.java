
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener{
    
    
    JTextField amount;
    JButton withdrawl,back;
    String pinnumber;
    
    Withdrawl(String pinnumber)
    {
        this.pinnumber=pinnumber;
        
        setLayout(null);
        
        ImageIcon i1=new ImageIcon (ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 800, 600);
        add(image);
        
        
        JLabel text=new JLabel("Please Enter the amount");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        text.setBounds(180, 190, 400, 20);
        image.add(text);
        
        amount=new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(180, 240,200, 20);
        image.add(amount);
        
        withdrawl=new JButton("Withdraw");
        withdrawl.setBounds(330, 320, 100, 30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        back=new JButton("Back");
        back.setBounds(330, 360, 100, 30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== withdrawl){
           String number=amount.getText();
           Date date=new Date();
           if(number.equals(""))
           {
              JOptionPane .showMessageDialog(null,"Please enter the amount you want to withdrawl");
           }else{
               try{
               con c=new con();
               String query="insert into bank values('"+pinnumber+"','"+date+"','withdrawl','"+number+"')";
               c.s.executeUpdate(query);
               JOptionPane .showMessageDialog(null,"Rs "+number+"withdrawl Successfully");
               setVisible(false);
               new Transaction(pinnumber).setVisible(true);                                         
           }catch(Exception e){
               System.out.println(e);
               
           }
           }
        }else if(ae.getSource()==back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Withdrawl("");
        
    }
    
}
