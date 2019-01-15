package com.company;

import java.sql.*;
import java.util.*;

public class Main {

    public static ArrayList<String> sqlUpdate() {
        ArrayList<String> names = new ArrayList<>();
        try {
            Properties properties = new Properties();
            properties.setProperty("user", "root");
            properties.setProperty("password", "kingsize");
            properties.setProperty("useSSL", "false");
            properties.setProperty("autoReconnect", "true");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", properties);
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select * from actor");

            while (result.next()) {
                names.add(result.getString("first_name") + " " + result.getString("last_name"));
            }

          /*  String insertSql = "insert into actor (first_name,last_name,last_update) values ('AZIZ','MAMAJANOV',20181120221412);";

            statement.executeUpdate(insertSql);
          */


        } catch (Exception e) {
            System.out.println(e.getClass());
        }
        return names;
    }

    public static void insertDataSql(String firstName, String lastName) {
        try {
            Properties properties = new Properties();
            properties.setProperty("user", "root");
            properties.setProperty("password", "kingsize");
            properties.setProperty("useSSL", "false");
            properties.setProperty("autoReconnect", "true");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", properties);

            Statement statement = connection.createStatement();

            String line = "insert into actor set first_name ='" + firstName + "' , last_name = '" + lastName + "';";

            statement.executeUpdate(line);

        } catch (Exception e) {
            System.out.println(e.getClass());
        }

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        myFrame frame = new myFrame();
        frame.setVisible(true);
    }
}
