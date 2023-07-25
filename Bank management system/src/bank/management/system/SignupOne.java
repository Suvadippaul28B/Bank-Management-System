
package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class SignupOne extends JFrame implements ActionListener{
    
   long random; 
   JTextField nameTextField,fathernameTextField,emailTextField,addTextField,cityTextField,stateTextField,pinTextField;
   JButton next;
   JRadioButton male,fmale,marri,unmarry;
   JDateChooser dateChooser;
    SignupOne()
    {
        setLayout(null);
        
        Random ran=new Random();
        random=Math.abs((ran.nextLong()%9000L)+1000L);
        
        JLabel formno= new JLabel("Application form no "+random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);
        
        
        JLabel personalDetails= new JLabel("page1 personal Details ");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,20));
        personalDetails.setBounds(290, 90, 400, 30);
        add(personalDetails);
        
        JLabel name= new JLabel("Name: ");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100, 140, 100, 30);
        add(name);
        
        nameTextField=new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,20));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);
        
        JLabel fathername= new JLabel("Father's Name: ");
        fathername.setFont(new Font("Raleway",Font.BOLD,20));
        fathername.setBounds(100, 180, 200, 30);
        add(fathername);
        
        fathernameTextField=new JTextField();
        fathernameTextField.setFont(new Font("Raleway",Font.BOLD,20));
        fathernameTextField.setBounds(300, 180, 400, 30);
        add(fathernameTextField);
        
        JLabel dob= new JLabel("Date of Birth: ");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100, 220, 200, 30);
        add(dob);
        
        dateChooser=new JDateChooser();
        dateChooser.setBounds(300,220,400,30);
        dateChooser.setForeground(Color.BLACK);
        add(dateChooser);
        
        JLabel gender= new JLabel("Gender: ");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100, 260, 200, 30);
        add(gender);
        
        male=new JRadioButton("Male");
        male.setBounds(300, 260, 150, 30);
        male.setBackground(Color.WHITE);
        add(male);
        
        fmale=new JRadioButton("Female");
        fmale.setBounds(450, 260, 300, 30);
        fmale.setBackground(Color.WHITE);
        add(fmale);
        
        ButtonGroup genbutton=new ButtonGroup();
        genbutton.add(male);
        genbutton.add(fmale);
       
        
        JLabel email= new JLabel("Email: ");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100, 290, 400, 30);
        add(email);
        
        emailTextField=new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,20));
        emailTextField.setBounds(300, 300, 400, 30);
        add(emailTextField);
        
        JLabel marry= new JLabel("Marital Status: ");
        marry.setFont(new Font("Raleway",Font.BOLD,20));
        marry.setBounds(100, 340, 200, 30);
        add(marry);
        
       marri=new JRadioButton("Married");
        marri.setBounds(300, 340, 150, 30);
        marri.setBackground(Color.WHITE);
        add(marri);
        
        unmarry=new JRadioButton("Unmarried");
        unmarry.setBounds(450, 340, 300, 30);
        unmarry.setBackground(Color.WHITE);
        add(unmarry);
        
        ButtonGroup genbutto=new ButtonGroup();
        genbutto.add(marri);
        genbutto.add(unmarry);
        
        
        JLabel add= new JLabel("Address: ");
        add.setFont(new Font("Raleway",Font.BOLD,20));
        add.setBounds(100, 380, 200, 30);
        add(add);
        
        addTextField=new JTextField();
        addTextField.setFont(new Font("Raleway",Font.BOLD,20));
        addTextField.setBounds(300, 380, 400, 30);
        add(addTextField);
        
        JLabel city= new JLabel("City: ");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100, 420, 200, 30);
        add(city);
        
        cityTextField=new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,20));
        cityTextField.setBounds(300, 420, 400, 30);
        add(cityTextField);
        
        JLabel state= new JLabel("State: ");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100, 460, 200, 30);
        add(state);
        
        stateTextField=new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,20));
        stateTextField.setBounds(300, 460, 400, 30);
        add(stateTextField);
        
        JLabel pin= new JLabel("Pincode: ");
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBounds(100, 500, 200, 30);
        add(pin);
        
        pinTextField=new JTextField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,20));
        pinTextField.setBounds(300, 500, 400, 30);
        add(pinTextField);
        
        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(600,560,100,30 );
        next.addActionListener(this);
        add(next);
        
        
       getContentPane().setBackground(Color.WHITE);
       
       
       setSize(850,800);
       setLocation(350,10);
       setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String formno=" "+random;
        String name=nameTextField.getText();
        String fathername=fathernameTextField.getText();
        String dob=((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected())
        {
            gender="Male";
        
        }else if(fmale.isSelected())
        {
            gender="Female";
        }
        String email=emailTextField.getText();
        String marry=null;
        if(marri.isSelected())
        {
            marry="Married";
        }else if(unmarry.isSelected())
        {
            marry="Unmarried";
        }
    String add=addTextField.getText();
    String city=cityTextField.getText();
    String state=stateTextField.getText();
    String pin=pinTextField.getText();
    
    
    
        try{
             if(name.equals("")){
                 JOptionPane.showMessageDialog(null,"Name is required");
             }else{
                 con c=new con();
                 String query="insert into signup values('"+formno+"','"+name+"','"+fathername+"','"+dob+"','"+gender+"','"+email+"','"+marry+"','"+add+"','"+city+"','"+state+"','"+pin+"')";
                 c.s.executeUpdate(query);
                 setVisible(false);
                 new SignupTwo(formno).setVisible(true);
             }
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        
    }
    public static void main(String args[]){
        new SignupOne();
    }
    
}
