/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doan_java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class DatabaseUtils {

    public static final String connectionUrl = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=QUANLYBANHANG;user=sa;password=123";

    public static Connection getDBConnect() {

        try {
            Connection con = null;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");// khai bao driver
            con = DriverManager.getConnection(connectionUrl);
            return con;
        } catch (ClassNotFoundException ex) {
            System.out.println("where is Driver?");// xuat hien thong bao de biet loi di`
            System.out.println("Error:" + ex.toString());
        } catch (SQLException ex) {
            //loi ket nooi 
            System.out.println("Error:" + ex.toString());
        }
        return null;
    }
}
