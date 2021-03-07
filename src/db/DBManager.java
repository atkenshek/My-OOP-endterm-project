package db;
/* Import libraries */
import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager implements IDBManager{ //created class DBManager
    @Override
    public Connection getConnection() {
        try{ //try-catch exeption
            Class.forName("org.postgresql.Driver"); //connecting driver for postgresql
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/EndTerm", "postgres", "m111202");
            return connection; //return connection
        }
        catch (Exception e){ //or catch the error and return null
            e.printStackTrace();
        }
        return null;
    }
}
