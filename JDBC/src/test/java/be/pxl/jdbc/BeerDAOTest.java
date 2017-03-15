package be.pxl.jdbc;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by tim_v on 14/03/2017.
 */
public class BeerDAOTest {
    @Test
    public void testGetBeerById() throws BeerException {
        // kijken of bier met id 5 in db zit
        // assign
        BeerDAO beerDAO = new BeerDAO();
        beerDAO.set_url("localhost");
        beerDAO.set_user("");
        beerDAO.set_password(""); // Don't even try cause this is on a local machine...
        // act
        Beer beer = beerDAO.getBeerById(5);
        // assert
        assertNotNull(beer);
        assertEquals(5,beer.getId());
    }

    @Test
    public void testUpdateBeer() throws BeerException {
        // assign
        Beer beer = new Beer();
        beer.setId(1);
        beer.setName("whine");
        beer.setAlcohol(0.35f);
        beer.setPrice(12.99f);
        beer.setStock(15);
        BeerDAO beerDAO = new BeerDAO();
        // act
        beerDAO.updateBeer(beer);
        // assert
    }

    @Test
    public void testDeleteBeer() throws BeerException {
        // assign
        Beer beer = new Beer();
        beer.setId(1);
        beer.setName("whine");
        beer.setAlcohol(0.35f);
        beer.setPrice(12.99f);
        beer.setStock(15);
        BeerDAO beerDAO = new BeerDAO();
        // act
        // assert
    }

    @Test
    public void testInsertBeer() throws BeerException {
        // assign
        Beer beer = new Beer();
        beer.setId(1);
        beer.setName("whine");
        beer.setAlcohol(0.35f);
        beer.setPrice(12.99f);
        beer.setStock(15);
        BeerDAO beerDAO = new BeerDAO();
        // act
        // assert
    }
}
