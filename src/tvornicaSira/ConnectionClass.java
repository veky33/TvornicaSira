package tvornicaSira;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;


public class ConnectionClass {
    private static String jdbcURL = "jdbc:mysql://localhost:3306/tvornicaSira"; // "?noAccessToProcedureBodies=true"
    private static String username = "root"; // "root"
    private static String password = "student"; // ""

    private static java.sql.Connection connection;


    public static java.sql.Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(jdbcURL, username, password);
                return connection;
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.printf("Greška!");
            }
        }
        return connection;
    }

    public static void main(String[] args) {

    }
}


