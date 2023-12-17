/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Db_Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author manh computer
 */
public class JDBC_Connection {
    public static java.sql.Connection getJDBCConnection(){
        final String url = "jdbc:mysql://localhost:3306/emenu";
        final String user = "root";
        final String password = "Manh@1307";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
