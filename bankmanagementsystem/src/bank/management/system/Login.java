/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**
 *
 * @author RAJASEKHAR
 */
public class Login extends JFrame implements ActionListener{
    
    JButton login,clear,signup;
    JTextField cardtextfield;
    JPasswordField pintextfield;
    Login(){
        setTitle("Automatic Teller Machine");
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100,100);
        add(label);
        
        JLabel text =new JLabel("welcome to ATM");
        text.setBounds(200,40,400,40);
        text.setFont(new Font("osward",Font.BOLD,36));
        add(text);
        
        JLabel cardno =new JLabel("Card no:");
        cardno.setBounds(120,150,150,30);
        cardno.setFont(new Font("osward",Font.BOLD,36));
        add(cardno); 
        
        cardtextfield =new JTextField();
        cardtextfield.setBounds(300,150,250,30);
        cardtextfield.setFont(new Font("Arial",Font.BOLD,14));
        add(cardtextfield);
        
        JLabel pin =new JLabel("PIN:");
        pin.setBounds(120,220,400,30);
        pin.setFont(new Font("osward",Font.BOLD,36));
        add(pin); 
        
        pintextfield =new JPasswordField();
        pintextfield.setBounds(300,220,250,30);
        pintextfield.setFont(new Font("Arial",Font.BOLD,14));
        add(pintextfield);
        
        
        login =new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
        
        clear =new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);
        
        signup =new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
       /* signup.setBackground(Color.black);
        signup.setForeground(Color.white);*/
        signup.addActionListener(this);
        add(signup);
        
        getContentPane().setBackground(Color.white);
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==clear){
            cardtextfield.setText("");
            pintextfield.setText("");
        }
        else if(ae.getSource()==signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
        else if(ae.getSource()==login){
            Conn conn=new Conn();
            String cardNumber=cardtextfield.getText();
            String pinNumber=pintextfield.getText();
            String query="Select * from login where cardnumber="+cardNumber+" and pin ="+pinNumber+"";
            try{
                ResultSet rs =conn.s.executeQuery(query);
                if(rs.next())
                {
                    setVisible(false);
                    new Transcations(pinNumber).setVisible(true);
                }
                else{
                   JOptionPane.showMessageDialog(null,"Please provide correct details"); 
                }
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
    public static void main(String args[])
    {
       new Login();
    }
}
