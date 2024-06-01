/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Transcations extends JFrame implements ActionListener{
    JLabel text;
    String pin;
    JButton deposit,withdrawl,ministatement,fastcash,exit,pinchange,balanceenquiry;
    Transcations(String pin)
    {
        this.pin=pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
         text = new JLabel("Please Select Your Transaction");
        text.setForeground(Color.WHITE);
        text.setBounds(325,320,700,35);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
         deposit=new JButton("Deposit");
        deposit.setBounds(280,400,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        
         withdrawl=new JButton("Withdrawl");
        withdrawl.setBounds(280,440,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
         fastcash=new JButton("Fast Cash");
        fastcash.setBounds(280,480,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
         pinchange=new JButton("Pin change");
        pinchange.setBounds(460,400,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
         ministatement=new JButton("Mini statement");
        ministatement.setBounds(460,431,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        balanceenquiry=new JButton("Balance Enquiry");
        balanceenquiry.setBounds(460,463,150,30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
         exit=new JButton("Exit");
        exit.setBounds(460,493,150,30);
        exit.addActionListener(this);
        image.add(exit);
        
        
        
        setLayout(null);
        setSize(900,900);
        setLocation(100,0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
     if(ae.getSource()==exit){
         System.exit(0);
         
     }   
     else if(ae.getSource()==deposit){
         setVisible(false);
         new Deposit(pin).setVisible(true);
     }
     else if(ae.getSource()==withdrawl)
     {
         setVisible(false);
         new Withdraw(pin).setVisible(true);
     }
     else if(ae.getSource()==fastcash){
         setVisible(false);
         new FastCash(pin).setVisible(true);
     }
     else if(ae.getSource()==pinchange)
     {
         setVisible(false);
         new PinChange(pin).setVisible(true);
     }
     else if(ae.getSource()==balanceenquiry)
     {
         setVisible(false);
         new BalanceEnquiry(pin).setVisible(true);
     }
     else if(ae.getSource()==ministatement)
     {
         setVisible(false);
         new MiniStatement(pin).setVisible(true);
     }
    }
    public static void main(String args[])
    {
        new Transcations("");
    }

 
}
