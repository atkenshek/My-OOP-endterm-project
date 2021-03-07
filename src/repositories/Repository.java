package repositories;
/* Import libraries*/
import db.IDBManager;
import entities.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Repository implements IRepository { //Implements to interface and created a dbManager
    private IDBManager dbManager;

    public Repository(IDBManager dbManager) { //Setter for dbManager
        setDbManager(dbManager);
    }

    public void setDbManager(IDBManager dbManager) { //Setter for dbManager
        this.dbManager = dbManager;
    }

    @Override
    public ArrayList<Product> searchProductByBrand(String brand) { //I created method which search by brand of clothes
        Connection connection;

        try { //Used try-cath exeptionshandlings
            connection = dbManager.getConnection(); //Getting a connection

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products WHERE brand LIKE '%" + brand + "%'"); //Sql statement
            ResultSet resultSet = preparedStatement.executeQuery(); //resultset which will store Query result

            ArrayList<Product> products = new ArrayList<>(); //created an array of Product
            while (resultSet.next()) {
                Product Product = new Product(resultSet.getInt("id"),
                        resultSet.getString("brand"),
                        resultSet.getString("model"),
                        resultSet.getString("size"),
                        resultSet.getDouble("price"),
                        resultSet.getString("manufacturer"));

                products.add(Product);
            }
            return products; //return product
        } catch (Exception e) { //If it's going wrong catch the exeption
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public ArrayList<Product> searchProductByModel(String model) { //I created ArrayList method which search by model of clothes
        Connection connection = null;

        try { //Used try-cath exeption handlings
            connection = dbManager.getConnection(); //Getting a connection

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products WHERE model LIKE '%" + model + "%'"); //Sql statement
            ResultSet resultSet = preparedStatement.executeQuery(); //Resultset which will store Query result

            ArrayList<Product> products = new ArrayList<>(); //Creating new array which store the result
            while (resultSet.next()) { //loop goes through whole table and adding the results in products
                Product Product = new Product(resultSet.getInt("id"),
                        resultSet.getString("brand"),
                        resultSet.getString("model"),
                        resultSet.getString("size"),
                        resultSet.getDouble("price"),
                        resultSet.getString("manufacturer"));

                products.add(Product);
            }
            return products; //return products
        } catch (Exception e) { //If it's going wrong catch the exeption
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public ArrayList<Product> searchProductBySize(String size) { //I created ArrayList method which search by size of clothes
        Connection connection; //Getting connection

        try { //Used try-cath exeption handlings
            connection = dbManager.getConnection(); //Getting connection

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products WHERE size LIKE '%" + size + "%'"); //Sql statement
            ResultSet resultSet = preparedStatement.executeQuery(); //Resultset which will store Query result

            ArrayList<Product> products = new ArrayList<>(); //Creating new array which store the result
            while (resultSet.next()) { //loop goes through table and adding the results in products
                Product Product = new Product(resultSet.getInt("id"),
                        resultSet.getString("brand"),
                        resultSet.getString("model"),
                        resultSet.getString("size"),
                        resultSet.getDouble("price"),
                        resultSet.getString("manufacturer"));

                products.add(Product);
            }
            return products;
        } catch (Exception e) { //If it's going wrong catch the exeption
            e.printStackTrace();
        }

        return null; //return null
    }

    @Override
    public ArrayList<Product> searchProductByManufacturer(String manufacturer) { //I created ArrayList method which search by model of clothes
        Connection connection = null; //Getting connection

        try { //Used try-cath exeption handlings
            connection = dbManager.getConnection(); //Getting connection

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products WHERE manufacturer LIKE '%" + manufacturer + "%'"); //Sql statement
            ResultSet resultSet = preparedStatement.executeQuery(); //Resultset which will store Query result

            ArrayList<Product> products = new ArrayList<>(); //Creating new array which store the result
            while (resultSet.next()) { //loop goes through whole table and adding the results in products
                Product Product = new Product(resultSet.getInt("id"),
                        resultSet.getString("brand"),
                        resultSet.getString("model"),
                        resultSet.getString("size"),
                        resultSet.getDouble("price"),
                        resultSet.getString("manufacturer"));

                products.add(Product);
            }
            return products; //return products
        } catch (Exception e) { //If it's going wrong catch the exeption
            e.printStackTrace();
        }

        return null; //return null
    }

    @Override
    public Product getProductByID(int id) { //Created a method which extends to Product
        Connection connection = null;

        try { //Used try-cath exeption handlings
            connection = dbManager.getConnection(); //Getting connection

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products WHERE id=?"); //Sql statement

            preparedStatement.setInt(1, id); //Set id which user entered

            ResultSet resultSet = preparedStatement.executeQuery();  //Resultset which will store Query result

            Product Product = new Product(); //Creating new product

            if (resultSet.next()) { //if id is exists then it will show the result
                Product.setId(resultSet.getInt("id"));
                Product.setBrand(resultSet.getString("brand"));
                Product.setModel(resultSet.getString("model"));
                Product.setSize(resultSet.getString("size"));
                Product.setPrice(resultSet.getDouble("price"));
                Product.setManufacturer(resultSet.getString("manufacturer"));
            }
            return Product; //return products
        } catch (Exception e) { //Or if it's going wrong catch the exeption
            e.printStackTrace();
        }
        return null; //return null
    }


    @Override
    public boolean setPriceByID(int id, double price) { //Created a method type of boolean
        Connection connection = null;

        try { //Used try-cath exeption handlings
            connection = dbManager.getConnection(); //Getting connection

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE products SET price = " + price + " WHERE id = " + id + ""); //Sql statement
            preparedStatement.execute(); //Executing my query
            return true; //return true
        } catch (Exception e) { //If it's going wrong catch the exeption
            e.printStackTrace();
        }
        return false; //return false
    }


    @Override
    public boolean addProduct(Product Product) { //Created a method type of boolean
        Connection connection = null;

        try { //Used try-cath exeption handlings
            connection = dbManager.getConnection(); //Getting connection

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO products(brand, model, size, price, manufacturer) VALUES ( ?, ?, ?, ?, ?)"); //Sql statement
            preparedStatement.setString(1, Product.getBrand());
            preparedStatement.setString(2, Product.getModel());
            preparedStatement.setString(3, Product.getSize());
            preparedStatement.setDouble(4, Product.getPrice());
            preparedStatement.setString(5, Product.getManufacturer());
            preparedStatement.execute();
            return true; //return true
        } catch (Exception e) { //If it's going wrong catch the exeption
            e.printStackTrace();

        }
        return false; //return false
    }

    @Override
    public boolean removeProduct(int id) {  //Created a method type of boolean
        Connection connection = null;
        try { //Used try-cath exeption handlings
            connection = dbManager.getConnection(); //Getting connection
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE from products WHERE id=?"); //SQL statement

            preparedStatement.setInt(1, id); //set id which user entered
            preparedStatement.execute(); //execute query
            return true; //return true
        } catch (Exception e) { //If it's going wrong catch the exeption
            e.printStackTrace();

        }
        return false; //return false
    }

    @Override
    public ArrayList<Product> showProducts() { //Created a method type of boolean
        Connection connection;

        try { //Used try-cath exeption handlings
            connection = dbManager.getConnection(); //Getting connection

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products"); //SQL statement
            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Product> companies = new ArrayList<>(); //Creating new array which stores the result
            while (resultSet.next()) { //loop which goes through whole table and adding the results in products
                Product Product = new Product( //Creating new objects of Product
                        resultSet.getInt("id"),
                        resultSet.getString("brand"),
                        resultSet.getString("model"),
                        resultSet.getString("size"),
                        resultSet.getDouble("price"),
                        resultSet.getString("manufacturer"));

                companies.add(Product); //Adding them
            }
            return companies;
        } catch (Exception e) { //If it's going wrong catch the exeption
            e.printStackTrace();
        }

        return null; //return null
    }


    @Override
    public Product showMinPrice() { //Created a method which extends to Product, to find the min price
        Connection connection = null;

        try { //Used try-cath exeption handlings
            connection = dbManager.getConnection(); //Getting connection

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products WHERE price = (SELECT MIN (price) FROM products)");
            ResultSet resultSet = preparedStatement.executeQuery(); //Resultset which will store Query result

            Product products = new Product(); //Creating new objects of Product
            if (resultSet.next()) { //Statement which will return min price
                Product product = new Product(
                        resultSet.getInt("id"),
                        resultSet.getString("brand"),
                        resultSet.getString("model"),
                        resultSet.getString("size"),
                        resultSet.getDouble("price"),
                        resultSet.getString("manufacturer"));

                products = product;
            }
            return products;
        } catch (Exception e) { //If it's going wrong catch the exeption
            e.printStackTrace();
        }

        return null; //return null

    }

    @Override
    public Product showMaxPrice() { //Created a method which extends to Product, to find the max price
        Connection connection = null;

        try { //Used try-cath exeption handlings
            connection = dbManager.getConnection(); //Getting connection

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products WHERE price = (SELECT MAX (price) FROM products)");
            ResultSet resultSet = preparedStatement.executeQuery(); //Executing query

            Product products = new Product(); //Creating new objects of Product
            if (resultSet.next()) { //Statement which will return max price
                Product product = new Product(
                        resultSet.getInt("id"),
                        resultSet.getString("brand"),
                        resultSet.getString("model"),
                        resultSet.getString("size"),
                        resultSet.getDouble("price"),
                        resultSet.getString("manufacturer"));

                products = product;
            }
            return products;
        } catch (Exception e) { //If it's going wrong catch the exeption
            e.printStackTrace();
        }

        return null; //return null

    }
}