import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        Connection con = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Driver Loaded");

            con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/college_event",
                    "root",
                    "root"
            );

            System.out.println("Connection Success");
            System.out.println(con);

        } catch(Exception e) {

            System.out.println("Database Connection Failed");

            e.printStackTrace();
        }

        return con;
    }
}