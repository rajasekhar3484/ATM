package bank.management.system;

import java.util.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

public class PinChange extends JFrame implements ActionListener{
    String pin;
    JLabel text,pintext,newpintext;
    JButton change,back;
    JPasswordField cpin,repin;
    PinChange(String pin)
    {
        this.pin=pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
         text=new JLabel("Change your Pin");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("system",Font.BOLD,16));
        text.setBounds(350,350,150,30);
        image.add(text);
        
         pintext=new JLabel("New Pin");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("system",Font.BOLD,16));
        pintext.setBounds(290,390,150,30);
        image.add(pintext);
        
         cpin=new JPasswordField();
        cpin.setForeground(Color.black);
        cpin.setBounds(400,390,150,30);
        cpin.setFont(new Font("system",Font.BOLD,16));
        image.add(cpin);
        
         newpintext=new JLabel("Re-enter Pin");
        newpintext.setForeground(Color.WHITE);
        newpintext.setFont(new Font("system",Font.BOLD,16));
        newpintext.setBounds(290,430,150,30);
        image.add(newpintext);
        
         repin=new JPasswordField();
        repin.setForeground(Color.black);
        repin.setBounds(400,430,150,30);
        repin.setFont(new Font("system",Font.BOLD,16));
        image.add(repin);
        
        
         change=new JButton("Change");
        change.setFont(new Font("system",Font.BOLD,14));
        change.setBounds(450,465,150,25);
        change.addActionListener(this);
        image.add(change);
        
         back=new JButton("Back");
        back.setFont(new Font("system",Font.BOLD,14));
        back.setBounds(450,495,150,25);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setLayout(null);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource()==change)
        {
        try{
            String opin=cpin.getText();
            String rpin=repin.getText();
            
            if(!opin.equals(rpin))
            {
               JOptionPane.showMessageDialog(null,"Entered pin does not match");
               return;
            }
             if(opin.equals("")){
                 JOptionPane.showMessageDialog(null,"Enter new pin match");
                 return;
             }
            if(rpin.equals("")){
                 JOptionPane.showMessageDialog(null,"Re enter new pin match");
                 return;
             }
            Conn c=new Conn();
            String query1="update bank set pin='"+rpin+"' where pin='"+pin+"'";
            String query2="update login set pin='"+rpin+"' where pin='"+pin+"'";
            String query3="update signupthree set pin='"+rpin+"' where pin='"+pin+"'";
            JOptionPane.showMessageDialog(null,"Pin changed Successfully");
            c.s.executeUpdate(query1);
            c.s.executeUpdate(query2);
            c.s.executeUpdate(query3);
            System.exit(0);
        }
        catch(Exception e){
            System.out.println(e);
        }
        
       }
        else{
            
            setVisible(false);
            new Transcations(pin).setVisible(true);
        
        }
    }
    
    public static void main(String args[])
    {
        new PinChange("");
    }

    
}
