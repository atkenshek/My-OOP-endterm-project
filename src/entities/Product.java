package entities;
/* Import libraries */
import java.lang.String;
public class Product { //Created class Product which stores our entities and made the private
    private int id;
    private String brand;
    private String model;
    private String size;
    private double price;
    private String manufacturer;
    public Product(){ //Empty constructor

    }
    public Product(int id, String brand, String model, String size, double price, String manufacturer){ //constructor
        setId(id);
        setBrand(brand);
        setModel(model);
        setSize(size);
        setPrice(price);
        setManufacturer(manufacturer);

    }

    public Product(String brand, String model, String size, Double price, String manufacturer) { //2nd Constructor without id
        setBrand(brand);
        setModel(model);
        setSize(size);
        setPrice(price);
        setManufacturer(manufacturer);
    }

    /* SETTERS & GETTERS*/
    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public  void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public  void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSize() {
        return size;
    }

    public  void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public  void setPrice(double price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public  void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() { //toString method which return our results
        return "Product{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                ", manufacturer='" + manufacturer + '\'' +
                '}' + '\n';
    }
}


