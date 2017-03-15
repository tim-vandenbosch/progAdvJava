package be.pxl.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by tim_v on 14/03/2017.
 */
public class ConnectDB {
    public static void main(String[] args) {
        try(Connection con = DriverManager.getConnection(
                "jdbc:mysql://noelvaes.eu/StudentDB",
                "student",
                "student123"
        ))
        {
            System.out.println("Connection OK");
        }
        catch (Exception e)
        {
            System.out.println("Oops, something went wrong!");
            e.printStackTrace(System.err);
        }
    }
}
