package bank;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import account.Account;
import bank.nonreachable.InReachbaleServer;
import customer.Customer;
import transaction.Transaction;

public class BankClient {

    private static final List<ServerInfo> SERVER_INFOS ;
    private BankInterface bankInterface;
    static{
    	SERVER_INFOS = new ArrayList<ServerInfo>();
    	SERVER_INFOS.add(new ServerInfo("localhost", 1099));
    	SERVER_INFOS.add(new ServerInfo("192.168.137.7", 1099));
    }
    public BankClient(){
    	bankInterface = checkServer();
    }

    public int registerUser(String firstName, String lastName, String userId, String password) {
        try {
            return bankInterface.registerUser(firstName, lastName, userId, password);
        } catch (Exception ex) {
            ex.printStackTrace();
            return 100;// Remote Exception
        }

    }

    public int login(String userId, String password) {
        try {
            return bankInterface.login(userId, password);
        } catch (Exception ex) {
            ex.printStackTrace();
            return 100;// Remote Exception
        }
    }

    public int createCustomer(String firstName, String lastName) {
        try {
            return bankInterface.createCustomer(firstName, lastName);
        } catch (Exception ex) {
            ex.printStackTrace();
            return 100;// Remote Exception
        }

    }

    public ArrayList<Customer> findCustomers() {
        try {
            return bankInterface.findCustomers();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Customer findCustomer(String custId) {
        try {
            return bankInterface.findCustomer(custId);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public int updateCustomer(String custId, String firstName, String lastName) {
        try {
            return bankInterface.updateCustomer(custId, firstName, lastName);
        } catch (Exception ex) {
            ex.printStackTrace();
            return 2;
        }
    }

    public int createAccount(String custId) {
        try {
            return bankInterface.createAccount(custId);
        } catch (Exception ex) {
            ex.printStackTrace();
            return 2;
        }
    }

    public int depositAccount(String custId, double amount) {
        try {
            return bankInterface.depositAccount(custId, amount);
        } catch (Exception ex) {
            ex.printStackTrace();
            return 2;
        }
    }

    public int withdrawAccount(String custId, double amount) {
        try {
            return bankInterface.withdrawAccount(custId, amount);
        } catch (Exception ex) {
            ex.printStackTrace();
            return 3;
        }
    }

    public int transferAmount(String custId1, String custId2, double amount) {
        try {
            return bankInterface.transferAmount(custId1, custId2, amount);
        } catch (Exception ex) {
            ex.printStackTrace();
            return 3;
        }
    }

    public ArrayList<Transaction> transactionDetails() {
        try {
            return bankInterface.transactionDetails();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<Account> accountDetails() {
        try {
            return bankInterface.accountDetails();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public int closeAccount(String custId) throws RemoteException {
        try {
            return bankInterface.closeAccount(custId);
        } catch (Exception ex) {
            ex.printStackTrace();
            return 1;
        }
    }

    public BankInterface checkServer() throws InReachbaleServer {
    	for(ServerInfo serverInfo : SERVER_INFOS){
    		try {
    			System.out.println("Checking Server :"+serverInfo.toString());
    			BankInterface bankInterface = (BankInterface) Naming.lookup("//" +
        				serverInfo.getIpAddress() + ":" + serverInfo.getPort() + "/Bank");
        		System.out.println("Server is active :"+serverInfo.toString());
    			return bankInterface;
    		} catch (Exception e) {
    			System.out.println("Server is inactive :"+serverInfo.toString());
    		}
    	}
        throw new InReachbaleServer();
    }
}