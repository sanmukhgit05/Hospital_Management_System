package hospital.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class login extends JFrame implements ActionListener {

    JTextField  textField;
    JPasswordField jPasswordField;
    JButton b1, b2;

    login(){

        JLabel namLabel = new JLabel("Username");
        namLabel.setBounds(40,20,100,30);
        namLabel.setFont(new Font("Tahoma", Font.BOLD,16));
        namLabel.setForeground(Color.BLACK);
        add(namLabel);

        JLabel password = new JLabel("Password");
        password.setBounds(40,70,100,30);
        password.setFont(new Font("Tahoma", Font.BOLD,16));
        password.setForeground(Color.BLACK);
        add(password);

        textField = new JTextField();
        textField.setBounds(150,20,190,30);
        textField.setFont(new Font("Tahoma", Font.PLAIN,16));
        textField.setBackground(Color.white);
        add(textField);

        jPasswordField = new JPasswordField();
        jPasswordField.setBounds(150,70,190,30);
        jPasswordField.setFont(new Font("Tahoma", Font.PLAIN,16));
        jPasswordField.setBackground(Color.white);
        add(jPasswordField);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));
        Image i1 = imageIcon.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon2);
        label.setBounds(290, 20, 460, 300);
        add(label);

        b1 = new JButton("Login");
        b1.setBounds(40, 140, 120, 30);
//        b1.setFont(new Font("serif", Font.BOLD, 15));
        b1.setFont(new Font("Thoma", Font.BOLD, 15));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(180, 140, 120, 30);
//        b2.setFont(new Font("serif", Font.BOLD, 15));
        b2.setFont(new Font("Thoma",Font.BOLD, 15 ));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);



        getContentPane().setBackground(new Color(109,164,170));
        setSize(750,300);
        setLocation(400,270);
        setLayout(null);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent E) {
        if(E.getSource() == b1){
           try{
               conn c = new conn();
               String user = textField.getText();
               String pass = jPasswordField.getText();

               String q = "select * from login where ID = '" +user+"' and PW = '" +pass+"'";
               ResultSet resultset = c.statement.executeQuery(q);

               if(resultset.next()){
                   new Reception();
                   setVisible(false);
               }
               else {
                   JOptionPane.showMessageDialog(null,"Invalid");
               }
           } catch (Exception e) {
               e.printStackTrace();
           }
        }
        else{
            System.exit(100);
        }
    }

    public static void main(String[] args){
        new login();
    }
}

