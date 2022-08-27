package com.cmc.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBDD {

    public static Connection connect(
            String host,
            String port,
            String database,
            String user,
            String password) {
        String connectionUrl = "jdbc:sqlserver://" + host + ":" + port + ";"
                + "database=" + database + ";"
                + "user=" + user + ";"
                + "password=" + password + ";"
                + "encrypt=false;"
                + "trustServerCertificate=false;"
                + "loginTimeout=10;";
        try {
            return DriverManager.getConnection(connectionUrl);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
