package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbManager {

    private String exceptionMessage;
    private java.sql.Connection connection;

    public DbManager() {

    }

    public boolean connectDatabase(String host, int port, String databaseName,
            String userName, String password,
            boolean autoCommit)  {

        try {
            if (connection != null && !connection.isClosed()) {
                return true;
            }
            Class.forName("com.mysql.jdbc.Driver");
            String dbUrl = prepareDatabaseURL(host, port, databaseName);
            connection = DriverManager.getConnection(dbUrl, userName, password);
            connection.setAutoCommit(autoCommit);
            return true;
        } catch (ClassNotFoundException ex) {
            exceptionMessage = "util.DbManager::connectDatabase "
                    + ex.getLocalizedMessage();
            System.out.println(exceptionMessage);
            ex.printStackTrace();
           
        } catch (SQLException ex) {
            exceptionMessage = "util.DbManager::connectDatabase "
                    + ex.getLocalizedMessage();
            System.out.println(exceptionMessage);
            
        }
        return true;
    }

    public boolean disconnectDatabase() {
        try {
            if (connection != null) {
                if (!connection.isClosed()) {
                    connection.close();
                    return true;
                }
                return true;
            }
        } catch (SQLException ex) {
            exceptionMessage = "util.DbManager::disconnectDatabase "
                    + ex.getLocalizedMessage();
            System.out.println(exceptionMessage);
            return false;
        }
        return false;
    }

    public Connection getConnection() {
        if (connection == null) {
            return null;
        }
        return connection;
    }

    private String prepareDatabaseURL(String host, int port,
            String databaseName) {
        String returnVal = new String();
        returnVal = "jdbc:mysql://" + host + ":" + port + "/" + databaseName;

        return returnVal;
    }

}
