package dao;

public class PUEntityManager {

    public static DbManager dbManager = new DbManager();

    public static DbManager getDbManager() {
        if (dbManager != null) {
            dbManager.connectDatabase("localhost", 3306, "ftbanking", "root", "root", true);
            return dbManager;
        } else {
            dbManager = new DbManager();
            dbManager.connectDatabase("localhost", 3306, "ftbanking", "root", "root", true);
            return dbManager;
        }
    }
}
