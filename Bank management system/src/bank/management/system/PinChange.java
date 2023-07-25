
package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class PinChange extends JFrame implements ActionListener {
    
    JPasswordField pin,rpin;
    JButton change,back;
    String pinnumber;
    
    PinChange(String pinnumber){
        this.pinnumber=pinnumber;
        
        setLayout(null);
        
        ImageIcon i1=new ImageIcon (ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 800, 600);
        add(image);
        
        
        JLabel text=new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        text.setBounds(200,170,700,35);
        image.add(text);
        
        
        JLabel pintext=new JLabel("NEW PIN: ");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("Raleway",Font.BOLD,16));
        pintext.setBounds(150,230,100,30);
        image.add(pintext);
        
        pin=new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,16));
        pin.setBounds(300,230,150,20);
        image.add(pin);
        
        
        JLabel rpintext=new JLabel("RE-ENTER PIN: ");
        rpintext.setForeground(Color.WHITE);
        rpintext.setFont(new Font("Raleway",Font.BOLD,16));
        rpintext.setBounds(150,260,150,30);
        image.add(rpintext);
        
        rpin=new JPasswordField();
        rpin.setFont(new Font("Raleway",Font.BOLD,16));
        rpin.setBounds(300,260,150,20);
        image.add(rpin);
        
        change=new JButton("CHANGE");
        change.setBounds(350, 310, 100, 30);
        change.addActionListener(this);
        image.add(change);
        
        back=new JButton("BACK");
        back.setBounds(350, 350, 100, 30);
        back.addActionListener(this);
        image.add(back);
        
        
        
        setSize(800,800);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change){
        try{
            String npin=pin.getText();
            String repin=rpin.getText();
            
            if(!npin.equals(repin)){
                JOptionPane.showMessageDialog(null,"Entered pin does not match");
                return;
            }
            if(!npin.equals(" ")){
              JOptionPane.showMessageDialog(null,"Please enter the new pin"); 
              return;
            }
            if(!repin.equals(" ")){
              JOptionPane.showMessageDialog(null,"Please re-enter new pin"); 
              return;
            }
            con c=new con();
            String query1="Update bank set pin='"+repin+"' where pin='"+pinnumber+"'";
            String query2="Update login set pin='"+repin+"' where pin='"+pinnumber+"'";
            String query3="Update signupthree set pin='"+repin+"' where pin='"+pinnumber+"'";
             
            c.s.executeUpdate(query1);
            c.s.executeUpdate(query2);
            c.s.executeUpdate(query3);
            JOptionPane.showMessageDialog(null,"Pin change successfully "); 
         
            
             setVisible(false);
            new Transaction(repin).setVisible(true);
            
        }catch(Exception e){
            System.out.println(e);
        }
        }else{
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
    
    public static void main (String args[]){
        new PinChange("").setVisible(true);
        
    }
    
}
