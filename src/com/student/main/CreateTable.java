package com.student.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/studentdb";
        String username = "postgres";
        String password = "user113030";   

        String sql = "CREATE TABLE IF NOT EXISTS students ("
                + "id SERIAL PRIMARY KEY, "
                + "name VARCHAR(50) NOT NULL, "
                + "email VARCHAR(100) UNIQUE NOT NULL, "
                + "age INT CHECK (age > 0), "
                + "mobile BIGINT"
                + ")";

        try {
          
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection(url, username, password);

            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);

            System.out.println("Table Created Successfully!");

            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}