package com.cmc.bdd;


import java.sql.Connection;

public class TestConnection {
    public static void main(String[] args) {

        Connection connection = ConnectionBDD.connect(
                "localhost",
                "1433",
                "cmc",
                "sa",
                "saPwd2020*");

        if (connection != null) {
            System.out.println("Connection success !");
        } else {
            System.out.println("Something goes wrong!");
        }
    }
}
