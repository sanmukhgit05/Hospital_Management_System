package hospital.management.system;

import com.mysql.cj.protocol.Resultset;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Employee_Info extends JFrame {
    Employee_Info(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,990,490);
        panel.setBackground(new Color(109,164,170));
        panel.setLayout(null);
        add(panel);

        JLabel labelName = new JLabel("Empoyeer's Information ");
        labelName.setBounds(388,5,260,67 );
        labelName.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(labelName);

        JTable table = new JTable();
        table.setBounds(10,94,950,250);
        table.setBackground(new Color(109,164,170));
        table.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
        panel.add(table);

        try{
            conn c = new conn();
            String q = "Select * from Emp_Info";
            ResultSet resultset = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultset));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("Name");
        label1.setBounds(15,60,200,30);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);

        JLabel label2 = new JLabel("Age");
        label2.setBounds(170,60,200,30);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);

        JLabel label3 = new JLabel("Salary");
        label3.setBounds(330,60,200,30);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label3);

        JLabel label4 = new JLabel("Phone_No");
        label4.setBounds(490,60,200,30);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label4);

        JLabel label5 = new JLabel("Gmail");
        label5.setBounds(670,60,200,30);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label5);

        JLabel label6 = new JLabel("Aadhar_NO");
        label6.setBounds(810,60,200,30);
        label6.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label6);

        JButton back = new JButton("Back");
        back.setBounds(410,420,120,31);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });



        setUndecorated(true);
        setSize(1000,500);
        setLocation(300,250);
        setLayout(null);
        setVisible(true);


    }

    public static void main(String[] args) {
       new Employee_Info();
    }
}
