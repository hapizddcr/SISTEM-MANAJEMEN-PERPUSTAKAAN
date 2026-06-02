/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

/**
 *
 * @author hapiz
 */

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Koneksi {

    private static Connection koneksi;

    public static Connection getConnection() {

        try {

            if(koneksi == null || koneksi.isClosed()) {

                // LOAD PROPERTIES

                Properties prop = new Properties();

                InputStream input =
                        Koneksi.class.getClassLoader()
                        .getResourceAsStream(
                                "config/database.properties"
                        );

                prop.load(input);

                // AMBIL DATA PROPERTIES

                String url =
                        prop.getProperty("db.url");

                String username =
                        prop.getProperty("db.username");

                String password =
                        prop.getProperty("db.password");

                // REGISTER DRIVER

                DriverManager.registerDriver(
                        new com.mysql.cj.jdbc.Driver()
                );

                // KONEKSI DATABASE

                koneksi =
                        DriverManager.getConnection(
                                url,
                                username,
                                password
                        );

                System.out.println(
                        "Koneksi database berhasil"
                );
            }

        } catch(Exception e) {

            System.out.println(
                    "Koneksi database gagal : "
                    + e.getMessage()
            );
        }

        return koneksi;
    }
}
