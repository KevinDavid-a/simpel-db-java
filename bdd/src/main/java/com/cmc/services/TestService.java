package com.cmc.services;

import com.cmc.bdd.ConnectionBDD;
import com.cmc.entities.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@SuppressWarnings("SqlDialectInspection")
public class TestService {
    @SuppressWarnings("SqlNoDataSourceInspection")
    public static void insert(Test test){
        Connection connection = ConnectionBDD.connect(
                "localhost",
                "1433",
                "cmc",
                "sa",
                "saPwd2020*");
        String sql = "exec st_test @i_codigo = ?, @i_nombre = ?, @i_operacion = ?";
        if (connection != null) {
            try {
                PreparedStatement pr = connection.prepareCall(sql);
                pr.setInt(1, test.getCodigo());
                pr.setString(2, test.getNombre());
                pr.setString(3,"I");
                pr.execute();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static ArrayList<Test> findAll() {
        ArrayList<Test> tests = new ArrayList<>();
        Connection connection = ConnectionBDD.connect(
                "localhost",
                "1433",
                "cmc",
                "sa",
                "saPwd2020*");
        String sql = "exec st_test @i_operacion = 'S'";
        if (connection != null) {
            try {
                PreparedStatement pr = connection.prepareCall(sql);
                ResultSet rs = pr.executeQuery();
                while (rs.next()) {
                    tests.add(new Test(
                            rs.getInt("t_codigo"),
                            rs.getString("t_nombre")));
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return tests;
    }
}
