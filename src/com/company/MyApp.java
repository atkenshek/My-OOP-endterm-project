package com.company;
/* Import libraries */
import controllers.Controller;
import java.util.Scanner;

public class MyApp {
    private final Controller controller; //Created final controller
    private final Scanner scanner; //Created final scanner

    public MyApp(Controller controller){ //Constructor which gives the value for controller and scanner
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void appStart(){
        while (true){
            System.out.println("Choose one option \n 1) Search for any clothes by brand\n 2) Add clothes...\n 3) Remove clothes\n 4) Get clothes by ID\n 5) Show all clothes..\n 6) Search for any clothes by model\n 7) Search for any clothes by size\n 8) Search for any clothes by manufacturer\n 9) Update price of product\n 10) Show min,max prices\n 0) Press 0 for exit\n");
            int choice = scanner.nextInt(); //Created a local variable choice
            /* User's choice(entered number) starts a method which situated in repository */
            if(choice == 1){
                searchProductByBrand();
            }
            else if (choice == 2){
                addProductMenu();
            }
            else if (choice == 3){
                removeProductByIdMenu();
            }
            else if (choice == 4){
                getProductByIdMenu();

            }
            else if (choice == 5){
                showProduct();
            }

            else if (choice == 6){
                searchProductByModel();
            }
            else if (choice == 7){
                searchProductBySize();
            }
            else if (choice == 8){
                searchProductByManufacturer();
            }
            else if (choice == 9){
                setPriceByIdMenu();
            }
            else if (choice == 10){
                showMinPrice();
            }


            else {
                break;
            }
            System.out.println("**********************************");
        }
    }
    public void searchProductByBrand(){
        System.out.println("Please, write brand of clothes below!");
        String brand = scanner.next();
        String result = controller.searchProductByBrand(brand);
        System.out.println("************** The result *******************\n");
        System.out.println(result);

    }
    public void searchProductByModel(){
        System.out.println("Please, write model of clothes below!");
        String model = scanner.next();
        String result = controller.searchProductByModel(model);
        System.out.println("************** The result *******************\n");
        System.out.println(result);

    }
    public void searchProductBySize(){
        System.out.println("Please, write size of clothes below!");
        String size = scanner.next();
        String result = controller.searchProductBySize(size);
        System.out.println("************** The result *******************\n");
        System.out.println(result);

    }
    public void searchProductByManufacturer(){
        System.out.println("Please, write the manufacturer of clothes below!");
        String manufacturer = scanner.next();
        String result = controller.searchProductByManufacturer(manufacturer);
        System.out.println("************** The result *******************\n");
        System.out.println(result);

    }
    public void showProduct(){
        System.out.println("************** The result *******************\n");
        System.out.println(controller.showProduct());
    }
    public void showMinPrice(){
        System.out.println("************** The result *******************\n");
        System.out.println("Smallest price: " + controller.showMinPrice() + '\n');
        System.out.println("Largest price: " + controller.showMaxPrice());
    }
    public void getProductByIdMenu(){
        System.out.println("Please, write ID of product below!");
        int id = scanner.nextInt();
        String result = controller.getProductByID(id);
        System.out.println("************** The result *******************\n");
        System.out.println(result);

    }
    public void setPriceByIdMenu(){
        System.out.println("Please, write ID and product and the price which you wanted to change below!");
        int id = scanner.nextInt();
        double price = scanner.nextDouble();
        String result = controller.setPriceByID(id, price);
        System.out.println("************** The result *******************\n");
        System.out.println(result);

    }
    public void addProductMenu(){
        System.out.println("Write the brand of product!");
        String brand = scanner.next();
        System.out.println("Write product's model!");
        String model = scanner.next();
        System.out.println("Write product size!");
        String size = scanner.next();
        System.out.println("Write price of product!");
        Double price = scanner.nextDouble();
        System.out.println("Write product's manufacturer!");
        String manufacturer = scanner.next();
        String result = controller.addProduct(brand, model, size, price, manufacturer);
        System.out.println(result);

    }
    public void removeProductByIdMenu(){
        System.out.println("Write product's id!");
        int id = scanner.nextInt();
        String result = controller.removeProductByID(id);
        System.out.println("************** The result *******************\n");
        System.out.println(result);
    }


}
