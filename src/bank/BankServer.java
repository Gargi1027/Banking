package bank;

import java.rmi.registry.Registry;

public class BankServer {

    public static void main(String[] args) {
        try {
            int port = 1099;
            try {
                port = Integer.parseInt(args[0]);
            } catch (Exception e) {
                port = 1099;
            }
            Registry r = java.rmi.registry.LocateRegistry.createRegistry(port);
            Bank bank = new Bank();
            r.rebind("Bank", bank);
            System.out.println("Server is started ....");
        } catch (Exception e) {
            System.out.println("Server not connected : ERROR= " + e);
        }
    }
}
