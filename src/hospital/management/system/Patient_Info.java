package hospital.management.system;

import com.mysql.cj.protocol.Resultset;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.jar.JarFile;

public class Patient_Info extends JFrame {
    Patient_Info(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(109, 164, 178));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("Patient Information");
        label.setBounds(300,10,320,30);
        label.setFont(new Font("Tahoma",Font.BOLD,20));
        label.setLayout(null);
        panel.add(label);

        JTable table = new JTable();
        table.setBounds(5,95,889,400);
        table.setBackground(new Color(109, 164, 178));
        table.setFont(new Font("Tahoma", Font.BOLD,12));
        table.setLayout(null);
        panel.add(table);

        try{
            conn c = new conn();
            String q = "Select * from Patient_Info";
            ResultSet resultset = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultset));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("ID");
        label1.setBounds(15,60,200,30);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);

        JLabel label2 = new JLabel("Name");
        label2.setBounds(120,60,200,30);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);

        JLabel label3 = new JLabel("Number");
        label3.setBounds(230,60,200,30);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label3);

        JLabel label4 = new JLabel("Gender ");
        label4.setBounds(340,60,200,30);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label4);

        JLabel label5 = new JLabel("Patient Disease");
        label5.setBounds(440,60,200,30);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label5);

        JLabel label6 = new JLabel("Room No");
        label6.setBounds(580,60,200,30);
        label6.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label6);

        JLabel label7 = new JLabel("Time");
        label7.setBounds(680,60,150,30);
        label7.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label7);

        JLabel label8 = new JLabel("Deposit");
        label8.setBounds(780,60,150,30);
        label8.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label8);

        JButton b1 = new JButton("BACK");
        b1.setBounds(400,510,130,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.setFont(new Font("Tahoma",Font.BOLD,18));
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(900,600);
        setLayout(null);
        setLocation(300, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Patient_Info();
    }
}
