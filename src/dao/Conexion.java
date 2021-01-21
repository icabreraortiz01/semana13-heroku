package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    public Connection connectToDB() {
        Connection connection = null;
        try {
            //Class.forName("org.postgresql.Driver");//localhost
            //connection = DriverManager.getConnection("jdbc:postgresql://engicoders:5432/dbusuario","postgres", "postgres");
            // Por favor conectate a la otra base de datos *****ojo
            connection = DriverManager.getConnection("jdbc:postgresql://ec2-52-205-61-60.compute-1.amazonaws.com:5432/dbs22pgdi9l6th","zeeibcjmueekoe", "85502f812dca3c9bd9c6327e063da9ab0a6c51654cac001941678a36064eaaf3");
            if (connection != null) {
                System.out.println("Se estableció la conexión :)");
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error al conectar a la base.");
            e.printStackTrace();
        }finally {
            return connection;
        }

    }
}
