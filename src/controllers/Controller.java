package controllers;
/* Import libraries */
import entities.Product;
import repositories.IRepository;
public class Controller { //Created a class Controller to interact with user

    private final IRepository repository; //Created final repository which will links to the methods from IRepository

    public Controller(IRepository repository) {
        this.repository = repository;
    }


    public String searchProductByBrand(String brand){
        return repository.searchProductByBrand(brand).toString();
    }

    public String searchProductByModel(String model){
        return repository.searchProductByModel(model).toString();
    }
    public String searchProductBySize(String size){
        return repository.searchProductBySize(size).toString();
    }
    public String searchProductByManufacturer(String manufacturer){
        return repository.searchProductByManufacturer(manufacturer).toString();
    }


    public String getProductByID(int id){
        return repository.getProductByID(id).toString();
    }
    public String setPriceByID(int id, double price){
        boolean updated = repository.setPriceByID(id, price);
        if(updated){
            return "The price was updated...";
        }
        return "The price was not updated :(...";
    }


    public String addProduct(String brand, String model, String size, Double price, String manufacturer){
        boolean added = repository.addProduct(new Product(brand, model, size, price, manufacturer));
        if(added){
            return "Product was added successfully! ";
        }
        return "Product was not added, please try again! ";
    }

    public String removeProductByID(int id){
        boolean removed = repository.removeProduct(id);
        if(removed){
            return "Product was removed successfully! ";
        }
        return "Product was not removed, please try again! ";
    }
    public String showProduct(){
        return repository.showProducts().toString();
    }
    public String showMinPrice(){
        return repository.showMinPrice().toString();
    }
    public Product showMaxPrice(){
        return repository.showMaxPrice();
    }

}

