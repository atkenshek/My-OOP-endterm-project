package repositories;
/* Import libraries */
import entities.Product;
import java.util.ArrayList;

public interface IRepository {
    ArrayList<Product> searchProductByBrand(String brand);
    ArrayList<Product> searchProductBySize(String size);
    ArrayList<Product> searchProductByManufacturer(String manufacturer);
    Product getProductByID(int id);
    boolean setPriceByID(int id, double price);
    boolean addProduct(Product Product);
    boolean removeProduct(int id);
    ArrayList<Product> showProducts();
    ArrayList<Product> searchProductByModel(String model);
    Product showMinPrice();
    Product showMaxPrice();


}
