package db;
/* Import libraries */
import java.sql.Connection;
public interface IDBManager {
    Connection getConnection(); //Getting a connection
}
