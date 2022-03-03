package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* Establishment the connection to database
 *@author   Ravi Kant
 *@version  1.0
 *@Since    03-02-2022
 */
public class MySqlConnection {
    //Connection Method
    public static Connection sqlConnection() {

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeinfo?useSSL=true","root","root");

            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
           return null;
        }
    }
}
