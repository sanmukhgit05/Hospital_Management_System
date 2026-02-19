 package hospital.management.system;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;

public class conn {

    Connection connection;
    Statement statement;

    public  conn(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_Managment_System", "root", "Sanmukh@12");
            statement = connection.createStatement();
            System.out.println("Database Connected Successfully...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
