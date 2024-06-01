package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener{
 
    JButton b1;
    JLabel mini;
    MiniStatement(String pin){
        super("Mini Statement");
        getContentPane().setBackground(Color.WHITE);
        setSize(400,600);
        setLocation(20,20);
        
        mini = new JLabel();
         mini.setBounds(20, 140, 400, 200);
        add(mini);
        
        JLabel bank = new JLabel("SBI Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);
        
        JLabel bal = new JLabel();
        bal.setBounds(20, 400, 300, 20);
        add(bal);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '"+pin+"'");
            while(rs.next()){
                card.setText("Card Number:    " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }
        }catch(Exception e){}
        	 
        try{
            int balance = 0;
            Conn c1  = new Conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank where pin = '"+pin+"'");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><html>");
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            bal.setText("Your total Balance is Rs "+balance);
        }catch(Exception e){
           System.out.println(e);
        }
        
        setLayout(null);
        b1 = new JButton("Exit");
        b1.addActionListener(this);
        b1.setBounds(240, 500, 100, 25);
        add(b1);
    }
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
    }
    
    public static void main(String[] args){
        new MiniStatement("").setVisible(true);
    }
    
}