package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame{
    Choice choice;

    JTable table;

    SearchRoom(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setBackground(new Color(109, 164, 178));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("Search For Room");
        label.setBounds(240,20, 200,20);
        label.setFont(new Font("Tahoma", Font.BOLD,20));
        label.setForeground(Color.WHITE);
        panel.add(label);

        JLabel label1 = new JLabel("Status : ");
        label1.setBounds(20,90, 120,16);
        label1.setFont(new Font("Tahoma", Font.BOLD,16));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        choice = new Choice();
        choice.setBounds(170,70,120,16);
        choice.add("Available");
        choice.add("Occupied");
        panel.add(choice);

        table = new JTable();
        table.setBounds(5,137,700,210);
        table.setBackground(new Color(109, 164, 178));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try{
            conn c = new conn();
            String q = "select * from Room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet ));
        }
        catch (Exception E){
            E.printStackTrace();
        }

        JLabel RoomNo = new JLabel("Room No ");
        RoomNo.setBounds(5,117, 120,16);
        RoomNo.setFont(new Font("Tahoma", Font.BOLD,14));
        RoomNo.setForeground(Color.WHITE);
        panel.add(RoomNo);

        JLabel available = new JLabel("Availability ");
        available.setBounds(175,117, 120,16);
        available.setFont(new Font("Tahoma", Font.BOLD,14));
        available.setForeground(Color.WHITE);
        panel.add(available);

        JLabel price = new JLabel("Price ");
        price.setBounds(355,117, 120,16);
        price.setFont(new Font("Tahoma", Font.BOLD,14));
        price.setForeground(Color.WHITE);
        panel.add(price);

        JLabel type = new JLabel("Room Type ");
        type.setBounds(535,117, 120,14);
        type.setFont(new Font("Tahoma", Font.BOLD,16));
        type.setForeground(Color.WHITE);
        panel.add(type);

        JButton search = new JButton("Search");
        search.setBounds(350, 380,120,30);
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        panel.add(search);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "select * from Room where Availability = '"+choice.getSelectedItem()+"'";
                try{
                   conn c = new conn();
                   ResultSet resultSet = c.statement.executeQuery(q);
                   table.setModel(DbUtils.resultSetToTableModel(resultSet));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(150, 380,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(700,500);
        setLayout(null);
        setLocation(350,250);
        setVisible(true);


    }

    public static void main(String[] args) {
        new SearchRoom();
    }
}
