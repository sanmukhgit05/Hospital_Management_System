package hospital.management.system;

import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Patient_Discharge extends JFrame {
    Patient_Discharge(){
      JPanel panel = new JPanel();
        panel.setBackground(new Color(109, 164, 178));
      panel.setBounds(5,5,790,390);
      panel.setLayout(null);
      add(panel);

      JLabel label = new JLabel("CHECK OUT ");
      label.setBounds(240,20, 150,20);
      label.setFont(new Font("Tahoma", Font.BOLD,20));
      label.setForeground(Color.WHITE);
      panel.add(label);

        JLabel label1 = new JLabel("Patient ID ");
        label1.setBounds(30,100, 150,20);
        label1.setFont(new Font("Tahoma", Font.BOLD,14));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        Choice choice = new Choice();
        choice.setBounds(200,100,150,20);
        panel.add(choice);

        try {
            conn c = new conn();
            ResultSet resultset = c.statement.executeQuery("select * from Patient_Info");
            while (resultset.next()){
                choice.add(resultset.getString("Number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label2 = new JLabel("Room No");
        label2.setBounds(30,150, 150,20);
        label2.setFont(new Font("Tahoma", Font.BOLD,14));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        JLabel Rno = new JLabel();
        Rno.setBounds(200,150, 150,20);
        Rno.setFont(new Font("Tahoma", Font.BOLD,14));
        Rno.setForeground(Color.WHITE);
        panel.add(Rno);

        JLabel label3 = new JLabel("In Time");
        label3.setBounds(30,200, 150,20);
        label3.setFont(new Font("Tahoma", Font.BOLD,14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JLabel InTime = new JLabel();
        InTime.setBounds(200,200, 250,20);
        InTime.setFont(new Font("Tahoma", Font.BOLD,14));
        InTime.setForeground(Color.WHITE);
        panel.add(InTime);

        JLabel label4 = new JLabel("Out TIme");
        label4.setBounds(30,250, 150,20);
        label4.setFont(new Font("Tahoma", Font.BOLD,14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        Date date = new Date();

        JLabel outTime = new JLabel(""+date);
        outTime.setBounds(200,250, 250,20);
        outTime.setFont(new Font("Tahoma", Font.BOLD,14));
        outTime.setForeground(Color.WHITE);
        panel.add(outTime);


        JButton Discharge = new JButton("Discharge");
        Discharge.setBounds(40, 300, 100, 30);
        Discharge.setBackground(Color.BLACK);
        Discharge.setFont(new Font("Tahoma",Font.BOLD,12));
        Discharge.setForeground(Color.WHITE);
        panel.add(Discharge);
        Discharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
                try{
                    c.statement.executeUpdate("delete from Patient_Info where number = '"+choice.getSelectedItem()+"'");
                    c.statement.executeUpdate("update Room set Availability = 'Available' where room_No = '"+Rno.getText()+"'");
                    JOptionPane.showMessageDialog(null,"Done");
                    setVisible(false);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton Check = new JButton("Check");
        Check.setBounds(180, 300, 100, 30);
        Check.setBackground(Color.BLACK);
        Check.setFont(new Font("Tahoma",Font.BOLD,12));
        Check.setForeground(Color.WHITE);
        panel.add(Check);
        Check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
                try{
                ResultSet resultSet = c.statement.executeQuery("select * from Patient_Info where number = '"+choice.getSelectedItem()+"'");
           while (resultSet.next()){
               Rno.setText(resultSet.getString("Room_No"));
               InTime.setText(resultSet.getString("Time"));
                 }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(320, 300, 100, 30);
        back.setBackground(Color.BLACK);
        back.setFont(new Font("Tahoma",Font.BOLD,12));
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });



      setUndecorated(true);
      setSize(800,400);
      setLocation(300,250);
      setLayout(null);
      setVisible(true);

    }

    public static void main(String[] args) {
        new Patient_Discharge();
    }
}
