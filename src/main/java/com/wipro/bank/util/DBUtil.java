package com.wipro.bank.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

    public static Connection getDBConnection() {
        Connection con = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "system";
            String pass = "System123";
            con = DriverManager.getConnection(url, user, pass);
 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
