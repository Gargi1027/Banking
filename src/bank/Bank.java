
package bank;

import account.Account;
import customer.Customer;
import dao.FTBankController;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import transaction.Transaction;


public class Bank extends UnicastRemoteObject implements BankInterface {

	private static final long serialVersionUID = 1L;

	public Bank() throws RemoteException {

    }

    @Override
	public int registerUser(String firstName, String lastName, String userId, String password) throws RemoteException {

        int intReturnValue = 0;
        FTBankController controller = new FTBankController();

        int intUserValid = controller.isValidUserId(userId);
        if (intUserValid == 0) {
            intReturnValue = controller.registerUser(firstName, lastName, userId, password);
        } else if (intUserValid == 1) {
            intReturnValue = 1;
        }
        return intReturnValue;
    }

    @Override
	public int login(String userId, String password) throws RemoteException {
        FTBankController controller = new FTBankController();
        return controller.login(userId, password);

    }

    @Override
	public int createCustomer(String firstName, String lastName) throws RemoteException {
        FTBankController controller = new FTBankController();
        return controller.createCustomer(firstName, lastName);
    }

    @Override
	public ArrayList<Customer> findCustomers() throws RemoteException {
        FTBankController controller = new FTBankController();
        return controller.findCustomers();
    }

    @Override
	public Customer findCustomer(String custId) throws RemoteException {
        FTBankController controller = new FTBankController();
        return controller.findCustomer(custId);
    }
    
    @Override
	public int updateCustomer(String custId,String firstName, String lastName)throws RemoteException{
        FTBankController controller = new FTBankController();
        return controller.updateCustomer(custId, firstName, lastName);
    }
    
    @Override
	public int createAccount(String custId) throws RemoteException{
        FTBankController controller = new FTBankController();
        return controller.createAccount(custId);
    }
    
    @Override
	public int depositAccount(String custId, double amount) throws RemoteException{
        FTBankController controller = new FTBankController();
        return controller.depositAccount(custId, amount);
    }

    @Override
	public int withdrawAccount(String custId, double amount) throws RemoteException{
        FTBankController controller = new FTBankController();
        return controller.withdrawAccount(custId, amount);
    }
    
    @Override
	public int transferAmount(String custId1, String custId2, double amount) throws RemoteException{
        FTBankController controller = new FTBankController();
        return controller.transferAmount(custId1, custId2, amount);
    }
    
    @Override
	public ArrayList<Transaction> transactionDetails() throws RemoteException{
        FTBankController controller = new FTBankController();
        return controller.transactionDetails();
    }
    
    @Override
	public ArrayList<Account> accountDetails()throws RemoteException{
        FTBankController controller = new FTBankController();
        return controller.accountDetails();
    }
    
    @Override
	public int closeAccount(String custId) throws RemoteException{
        FTBankController controller = new FTBankController();
        return controller.closeAccount(custId);
    }
}
