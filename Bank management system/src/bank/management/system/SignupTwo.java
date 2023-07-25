package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {
    JTextField aadhar, pan;
    JButton next;
    JRadioButton syes, sno, eyes, eno;

    JComboBox<String> religion, category, income, education, occupation;
    String formno;

    SignupTwo(String formno) {
        this.formno = formno;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM-PAGE2");

        JLabel additionalDetails = new JLabel("page2 ADDITIONAL Details ");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 20));
        additionalDetails.setBounds(290, 90, 400, 30);
        add(additionalDetails);

        JLabel name = new JLabel("Religion: ");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);

        String Valreligion[] = { "Hindu", "Muslim", "Sikh", "Christian", "Others" };
        religion = new JComboBox<>(Valreligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel fathername = new JLabel("Category: ");
        fathername.setFont(new Font("Raleway", Font.BOLD, 20));
        fathername.setBounds(100, 180, 200, 30);
        add(fathername);

        String Valcategory[] = { "General", "SC", "ST", "Others" };
        category = new JComboBox<>(Valcategory);
        category.setBounds(300, 180, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel dob = new JLabel("Income: ");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 220, 200, 30);
        add(dob);

        String Valincome[] = { "Null", "<1,50,0000", "<2,50,0000", "<5,00,0000" };
        income = new JComboBox<>(Valincome);
        income.setBounds(300, 220, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);

        JLabel gender = new JLabel("Education: ");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 260, 200, 30);
        add(gender);

        JLabel email = new JLabel("Qualification: ");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 275, 400, 30);
        add(email);

        String educationValues[] = { "Non-Graduate", "Graduate", "Post-Graduate", "Others" };
        education = new JComboBox<>(educationValues);
        education.setBounds(300, 260, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);

        JLabel marry = new JLabel("Occupation: ");
        marry.setFont(new Font("Raleway", Font.BOLD, 20));
        marry.setBounds(100, 340, 200, 30);
        add(marry);

        String Valoccupation[] = { "Salaried", "Self-Employee", "Business", "Retired" };
        occupation = new JComboBox<>(Valoccupation);
        occupation.setBounds(300, 300, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        JLabel add = new JLabel("PAN No: ");
        add.setFont(new Font("Raleway", Font.BOLD, 20));
        add.setBounds(100, 380, 200, 30);
        add(add);

        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(300, 380, 400, 30);
        add(pan);

        JLabel city = new JLabel("Aadhar No: ");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 420, 200, 30);
        add(city);

        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhar.setBounds(300, 420, 400, 30);
        add(aadhar);

        JLabel state = new JLabel("Senior Citizen: ");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 460, 200, 30);
        add(state);

        syes = new JRadioButton("Yes");
        syes.setBounds(300, 460, 300, 30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450, 460, 300, 30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup genbutto = new ButtonGroup();
        genbutto.add(syes);
        genbutto.add(sno);

        JLabel pin = new JLabel("Existing account: ");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(100, 500, 200, 30);
        add(pin);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 510, 300, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450, 510, 300, 30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup egenbutto = new ButtonGroup();
        egenbutto.add(eyes);
        egenbutto.add(eno);

        JButton next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(600, 560, 100, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String seniorcitizen = syes.isSelected() ? "Yes" : "No";
        String existingaccount = eyes.isSelected() ? "Yes" : "No";
        String span = pan.getText();
        String saadhar = aadhar.getText();

        try {
            con c = new con(); // Assuming con class provides database connectivity
            String query = "insert into signuptwo values('" + formno + "','" + sreligion + "','" + scategory + "','"
                    + sincome + "','" + seducation + "','" + soccupation + "','" + span + "','" + saadhar + "','"
                    + seniorcitizen + "','" + existingaccount + "')";
            c.s.executeUpdate(query);
            setVisible(false);
            new SignupThree(formno).setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
        new SignupTwo("");
    }
}
