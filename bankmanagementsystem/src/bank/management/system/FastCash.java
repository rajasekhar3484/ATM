/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
public class FastCash extends JFrame implements ActionListener{
    JLabel text;
    String pin;
    JButton deposit,withdrawl,ministatement,fastcash,exit,pinchange,balanceenquiry;
    FastCash(String pin)
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
        
         deposit=new JButton("Rs 100");
        deposit.setBounds(280,400,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        
         withdrawl=new JButton("Rs 500");
        withdrawl.setBounds(280,440,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
         fastcash=new JButton("Rs 1000");
        fastcash.setBounds(280,480,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
         pinchange=new JButton("Rs 2000");
        pinchange.setBounds(460,400,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
         ministatement=new JButton("Rs 5000");
        ministatement.setBounds(460,431,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        balanceenquiry=new JButton("Rs 10000");
        balanceenquiry.setBounds(460,463,150,30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
         exit=new JButton("Back");
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
         new Transcations(pin).setVisible(true);
         
     }   
     else {
         String amount=((JButton)ae.getSource()).getText().substring(3);
         Conn c=new Conn();
         try{
             ResultSet rs=c.s.executeQuery("select * from bank where pin ="+pin+"");
             int balance=0;
             while(rs.next()){
                 if(rs.getString("type").equals("Deposit")){
                     balance+=Integer.parseInt(rs.getString("amount"));
                 }
                 else{
                     balance-=Integer.parseInt(rs.getString("amount"));
                 }
             }
             if(balance<Integer.parseInt(amount)){
                 JOptionPane.showMessageDialog(null,"Insufficient Balance");
                 return;
             }
             Date d=new Date();
             String query="insert into bank values('"+pin+"','"+d+"','withdraw','"+amount+"')";
             c.s.executeUpdate(query);
             JOptionPane.showMessageDialog(null,"Rs"+amount+" Debited succesfully");
             setVisible(false);
             new Transcations("").setVisible(true);
         }
         catch(Exception e){
             System.out.println(e);
         }
     }
     
    }
    public static void main(String args[])
    {
        new FastCash("");
    }

 
}
