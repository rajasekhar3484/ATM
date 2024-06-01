/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
    JLabel text;
    JButton back;
    String pin;
    BalanceEnquiry(String pin)
    {
        this.pin=pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        Conn c=new Conn();
        int balance=0;
        try{
            
             ResultSet rs=c.s.executeQuery("select * from bank where pin ="+pin+"");
             
             while(rs.next()){
                 if(rs.getString("type").equals("Deposit")){
                     balance+=Integer.parseInt(rs.getString("amount"));
                 }
                 else{
                     balance-=Integer.parseInt(rs.getString("amount"));
                 }
             }
        }catch(Exception e){
            System.out.println(e);
        }
        
        text = new JLabel("Your account balance is "+balance+" ");
        text.setForeground(Color.WHITE);
        text.setBounds(325,320,700,35);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        back=new JButton("Back");
        back.setBounds(450,450,120,30);
        back.setForeground(Color.black);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        setLayout(null);
    }
    public static void main(String args[])
    {
        new BalanceEnquiry("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource()==back)
            {
                setVisible(false);
                new Transcations(pin).setVisible(true);
            }
        }
        catch(Exception ee){
            System.out.println(ee);
        }
    }
}
