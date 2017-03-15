package be.pxl.jdbc;

/**
 * Created by tim_v on 14/03/2017.
 */
public class Beer {
    private int id;
    private String name;
    private float price;
    private  int stock;
    private float alcohol;

    public Beer(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(float alcohol) {
        this.alcohol = alcohol;
    }

    public void setId(int id) {

        this.id = id;
    }

    public int getId(){
        return id;
    }

    @Override
    public String toString() {
        return "Beer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", alcohol=" + alcohol +
                '}';
    }
}
