/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Deposit extends JFrame implements ActionListener{
    JLabel text;
    JTextField amounttext;
    JButton deposit,back;
    String pin;
    Deposit(String pin)
    {
        this.pin=pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        text=new JLabel("Enter amount do you want to deposit");
        text.setFont(new Font("system",Font.BOLD,16));
        text.setBounds(325,340,750,35);
        text.setForeground(Color.WHITE);
        image.add(text);
        
        amounttext=new JTextField();
        amounttext.setBounds(320,380,300,35);
        image.add(amounttext);
        
        
        deposit=new JButton("Deposit");
        deposit.setBounds(460,450,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        
         back=new JButton("Back");
        back.setBounds(460,490,150,30);
        back.addActionListener(this);
        image.add(back);
        
        setLayout(null);
        setSize(900,900);
        setLocation(100,0);
        setVisible(true);
    }
   

    @Override
    public void actionPerformed(ActionEvent ae) {
         try{        
            String amount = amounttext.getText();
            Date date = new Date();
            if(ae.getSource()==deposit){
                if(amounttext.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
                }else{
                    Conn c1 = new Conn();
                    c1.s.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Deposit', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Deposited Successfully");
                    setVisible(false);
                    new Transcations(pin).setVisible(true);
                }
            }else if(ae.getSource()==back){
                setVisible(false);
                new Transcations(pin).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(ae);
        }
    }
    public static void main(String args[])
   {
       new Deposit("");
   }
}
