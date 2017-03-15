package be.pxl.jdbc;
import java.sql.*;
import java.io.*;
import java.util.*;

/**
 * Created by tim_v on 14/03/2017.
 */
public class BeerDAO {
    private String _url, _user, _password;
    public BeerDAO(){}

    public BeerDAO(String url, String user, String password){
        _url = url;
        _user = user;
        _password = password;
    }

    public void set_url(String _url) {
        this._url = _url;
    }

    public void set_user(String _user) {
        this._user = _user;
    }

    public void set_password(String _password) {
        this._password = _password;
    }

    public Beer getBeerById(int beerId) throws BeerException {
        try(Connection con = getConnection();
            PreparedStatement statement = con.prepareStatement("SELECT * FROM Beers WHERE Id=?"))
        {
            statement.setInt(1, beerId);
            try (ResultSet resultSet = statement.executeQuery()){
                if(resultSet.next()){
                    Beer beer = new Beer();
                    beer.setId(beerId);
                    beer.setName(resultSet.getString("Name"));
                    beer.setPrice(resultSet.getFloat("Price"));
                    beer.setAlcohol(resultSet.getFloat("Alcohol"));
                    beer.setStock(resultSet.getInt("Stock"));
                    return beer;
                } else
                {
                    return null;
                }
            }
        } catch (SQLException sqlE){
            throw new BeerException(sqlE);
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(_url,_user,_password);
    }

    public void updateBeer(Beer beer) throws BeerException {
        try(Connection con = getConnection();
            PreparedStatement statement = con.prepareStatement("UPDATE Beers SET Name=?, Price=?, Alcohol=?, Stock=? WHERE  Id=?"))
        {
            statement.setString(1, beer.getName());
            statement.setFloat(2, beer.getPrice());
            statement.setFloat(3, beer.getAlcohol());
            statement.setInt(4, beer.getStock());
            statement.setInt(5, beer.getId());
            statement.executeUpdate();
        } catch (SQLException sqlE) {
            throw new BeerException(sqlE);
        }
    }
}
