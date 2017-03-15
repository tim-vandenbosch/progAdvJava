package be.pxl.jdbc;

import java.sql.SQLException;

/**
 * Created by tim_v on 14/03/2017.
 */
public class BeerException extends Throwable {
    public BeerException(SQLException sqlE) {
        System.out.println("BeerException: " + sqlE);
    }
}
