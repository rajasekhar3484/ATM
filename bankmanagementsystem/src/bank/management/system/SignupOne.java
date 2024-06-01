/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
/**
 *
 * @author RAJASEKHAR
 */
public class SignupOne extends JFrame implements ActionListener{
    
    long random;
    JTextField nametextfield,fnametextfield,emailtextfield,addresstextfield,citytextfield,statetextfield,pintextfield;
    JButton next;
    JRadioButton male,female,married,unmarried;
    JDateChooser datechoose;
    
    SignupOne(){
        setLayout(null);
        
        Random ran =new Random();
         random = Math.abs((ran.nextLong() % 9000L) + 1000L);
        
        JLabel formno =new JLabel("APPLICATION FORM NO : "+random);
        formno.setBounds(140,20,600,40);
        formno.setFont(new Font("Raleway",Font.BOLD,40));
        add(formno);
        
        JLabel personaldetails =new JLabel("Page 1: Personal Details");
        personaldetails.setBounds(290,80,400,30);
        personaldetails.setFont(new Font("Raleway",Font.BOLD,22));
        add(personaldetails);
        
        
        JLabel name =new JLabel("Name:");
        name.setBounds(100,140,100,30);
        name.setFont(new Font("Raleway",Font.BOLD,22));
        add(name);
        
         nametextfield = new JTextField();
        nametextfield.setBounds(300,140,400,30);
        nametextfield.setFont(new Font("Raleway",Font.BOLD,14));
        add(nametextfield);
        
        
        JLabel fname =new JLabel("Father Name:");
        fname.setBounds(100,190,200,30);
        fname.setFont(new Font("Raleway",Font.BOLD,22));
        add(fname);
        
         fnametextfield = new JTextField();
        fnametextfield.setBounds(300,190,400,30);
        fnametextfield.setFont(new Font("Raleway",Font.BOLD,14));
        add(fnametextfield);
        
        JLabel dob =new JLabel("Date of Birth:");
        dob.setBounds(100,240,200,30);
        dob.setFont(new Font("Raleway",Font.BOLD,22));
        add(dob);
        
         datechoose = new JDateChooser();
        datechoose.setBounds(300,240,400,30);
        add(datechoose);
        
        JLabel email =new JLabel("Email:");
        email.setBounds(100,290,100,30);
        email.setFont(new Font("Raleway",Font.BOLD,22));
        add(email);
        
        
         emailtextfield = new JTextField();
        emailtextfield.setBounds(300,290,400,30);
        emailtextfield.setFont(new Font("Raleway",Font.BOLD,14));
        add(emailtextfield);
        
        JLabel gender =new JLabel("Gender:");
        gender.setBounds(100,340,100,30);
        gender.setFont(new Font("Raleway",Font.BOLD,22));
        add(gender);
        
         male = new JRadioButton("Male:");
        male.setBounds(300,340,60,30);
        male.setBackground(Color.white);
        add(male);
        
         female = new JRadioButton("Female:");
        female.setBounds(450,340,120,30);
        female.setBackground(Color.white);
        add(female);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        
        
        JLabel marital =new JLabel("Marital Status:");
        marital.setBounds(100,390,200,30);
        marital.setFont(new Font("Raleway",Font.BOLD,22));
        add(marital);
        
         married = new JRadioButton("Married:");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.white);
        add(married);
        
         unmarried = new JRadioButton("Un Married:");
        unmarried.setBounds(450,390,100,30);
        unmarried.setBackground(Color.white);
        add(unmarried);
        
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        
        JLabel address=new JLabel("Adddress:");
        address.setBounds(100,440,150,30);
        address.setFont(new Font("Raleway",Font.BOLD,22));
        add(address);
        
         addresstextfield = new JTextField();
        addresstextfield.setBounds(300,440,400,30);
        addresstextfield.setFont(new Font("Raleway",Font.BOLD,14));
        add(addresstextfield);
        
        JLabel city=new JLabel("City:");
        city.setBounds(100,490,100,30);
        city.setFont(new Font("Raleway",Font.BOLD,22));
        add(city);
        
         citytextfield = new JTextField();
        citytextfield.setBounds(300,490,400,30);
        citytextfield.setFont(new Font("Raleway",Font.BOLD,14));
        add(citytextfield);
        
        JLabel state=new JLabel("State:");
        state.setBounds(100,540,100,30);
        state.setFont(new Font("Raleway",Font.BOLD,22));
        add(state);
        
         statetextfield = new JTextField();
        statetextfield.setBounds(300,540,400,30);
        statetextfield.setFont(new Font("Raleway",Font.BOLD,14));
        add(statetextfield);
        
        JLabel pin=new JLabel("Pincode:");
        pin.setBounds(100,590,100,30);
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        add(pin);
        
         pintextfield = new JTextField();
        pintextfield.setBounds(300,590,400,30);
        pintextfield.setFont(new Font("Raleway",Font.BOLD,14));
        add(pintextfield);
        
        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setBounds(600,660,80,30);
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);
        
        
        getContentPane().setBackground(Color.white);
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
     String formno = "" + random;
     String name=nametextfield.getText();
     String fname=fnametextfield.getText();
     String dob = ((JTextField)datechoose.getDateEditor().getUiComponent()).getText();
     String gender=null;
     if(male.isSelected()){
         gender="Male";
     }
     else if(female.isSelected()){
         gender="Female";
     }
     String email=emailtextfield.getText();
     String marital=null;
     if(married.isSelected()){
         marital="Married";
         }
     else if(unmarried.isSelected()){
         marital="Unmarried";
         
     }
     String address=addresstextfield.getText();
     String city=citytextfield.getText();
     String state=statetextfield.getText();
     String pin=pintextfield.getText();
     
     
     
    try{
        
        if(name.equals("")){
            JOptionPane.showMessageDialog(null,"Name is required");
        }
        else{
            Conn c = new Conn();
            String query = "insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+pin+"', '"+state+"')";
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
