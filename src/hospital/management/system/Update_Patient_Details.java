package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Update_Patient_Details extends JFrame {
    Update_Patient_Details(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,940,540);
        panel.setBackground(new Color(109, 164, 178));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/updated.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label0 = new JLabel(imageIcon1);
        label0.setBounds(500,60,300,300);
        panel.add(label0);

        JLabel label = new JLabel("UPDATE PATIENT DETAILS  ");
        label.setBounds(140,20, 150,20);
        label.setFont(new Font("Tahoma", Font.BOLD,20));
        label.setForeground(Color.WHITE);
        panel.add(label);

        JLabel label1 = new JLabel("Name : ");
        label1.setBounds(30,100, 150,20);
        label1.setFont(new Font("Tahoma", Font.BOLD,14));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        Choice choice = new Choice();
        choice.setBounds(250,100,178,20);
        panel.add(choice);

        try {
            conn c = new conn();
            ResultSet resultset = c.statement.executeQuery("select * from Patient_Info");
            while (resultset.next()){
                choice.add(resultset.getString("Name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label2 = new JLabel("Room Number");
        label2.setBounds(30,150, 150,20);
        label2.setFont(new Font("Tahoma", Font.BOLD,14));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        JTextField textField =  new JTextField();
        textField.setBounds(250,150,178,20);
        panel.add(textField);

        JLabel label3 = new JLabel("In Time");
        label3.setBounds(30,200, 150,20);
        label3.setFont(new Font("Tahoma", Font.BOLD,14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JTextField textField2 =  new JTextField();
        textField2.setBounds(250,200,178,20);
        panel.add(textField2);

        JLabel label4 = new JLabel("Amount Paid(In Rs)");
        label4.setBounds(30,250, 150,20);
        label4.setFont(new Font("Tahoma", Font.BOLD,14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JTextField textField3 =  new JTextField();
        textField3.setBounds(250,250,178,20);
        panel.add(textField3);

        JLabel label5 = new JLabel("Pending Amount(Rs)");
        label5.setBounds(30,300, 160,20);
        label5.setFont(new Font("Tahoma", Font.BOLD,14));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        JTextField textField4 =  new JTextField();
        textField4.setBounds(250,300,178,20);
        panel.add(textField4);

        JButton back = new JButton("Back");
        back.setBounds(30,400,120,30);
        back.setFont(new Font("Tahoma",Font.BOLD,14));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

    JButton check = new JButton("Check Details");
    check.setBounds(170,400,150,30);
    check.setFont(new Font("Tahoma",Font.BOLD,14));
    check.setBackground(Color.BLACK);
    check.setForeground(Color.WHITE);
    panel.add(check);
    check.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String id = choice.getSelectedItem();
            String q = "select * from patient_Info where Name = '"+id+"'";
            try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery(q);
            while (resultSet.next()){
                textField.setText(resultSet.getString("Room_No"));
                textField2.setText((resultSet.getString("time")));
                textField3.setText((resultSet.getString("Deposit")));
            }
            ResultSet resultSet1 = c.statement.executeQuery("select * from Room where room_No = '"+textField.getText()+"'");
        while (resultSet1.next()){
            String price = resultSet1.getString("Price");
            int amtPaid = Integer.parseInt(price) - Integer.parseInt(textField3.getText());
            textField4.setText("" +amtPaid);
        }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    });


        JButton update = new JButton("Update");
        update.setBounds(350,400,120,30);
        update.setFont(new Font("Tahoma",Font.BOLD,14));
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    conn c = new conn();
                    String q = choice.getSelectedItem();
                    String room = textField.getText();
                    String time = textField2.getText();
                    String price = textField3.getText();
                    c.statement.executeUpdate("update Patient_Info set Room_No = '"+room+"', Time = '"+time+"', Deposit = '"+price+"' where name = '"+q+"'");
                    JOptionPane.showMessageDialog(null,"Updated Successfully");
                    setVisible(false);
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });







        setSize(950,550);
        setLayout(null);
        setLocation(350,250);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Update_Patient_Details();
    }
}
