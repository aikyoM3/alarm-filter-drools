package dbconnection;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;



import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;


public class MongoConnection {
    @SuppressWarnings({ "deprecation", "resource" })
    public static DBCursor getDBCursor() {
        Properties prop = new Properties();
        String fileName = "drools-simple-demo/src/config/db.config";
        try (FileInputStream fis = new FileInputStream(fileName)) {
            prop.load(fis);
            System.out.println("Properties loaded: " + prop);
        } catch (FileNotFoundException ex) {
            System.out.println("File not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("IO Exception: " + ex.getMessage());
        }
    
        String host = prop.getProperty("db.host", "127.0.0.1");
        String portStr = prop.getProperty("db.port", "27017");
        String database = prop.getProperty("db.database");
        String collection = prop.getProperty("db.collection");
    
        int port;
        try {
            port = Integer.parseInt(portStr);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Invalid port number: " + portStr, ex);
        }
    
        String uriString = String.format("mongodb://%s:%d/%s", host, port, database);
        MongoClientURI uri = new MongoClientURI(uriString);
        MongoClient mongodb = new MongoClient(uri);
        DB db = mongodb.getDB(database);
        DBCollection dbCollection = db.getCollection(collection);
    
        return dbCollection.find();
    }
    
//handle CLI command suffixes
public static DBCursor getDBCursor(String configFilePath) {
    return null;
    }
}

