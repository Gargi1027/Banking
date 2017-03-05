package dao;

import account.Account;
import customer.Customer;
import dao.PUEntityManager;
import java.sql.*;
import java.util.ArrayList;
import transaction.Transaction;

public class FTBankController {

    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement pstmt = null;

    public int registerUser(String firstName, String lastName, String userId, String password) {
        int intRetVal = 0;
        Connection conn = null;
        try {
            conn = PUEntityManager.getDbManager().getConnection();
            StringBuffer f = new StringBuffer();

            f.append("");
            f.append(" INSERT INTO TblTeller  \n");
            f.append("( FIRSTNAME,LASTNAME,USERID,PASSWORD) VALUES \n");
            f.append("( '" + firstName + "','" + lastName + "','" + userId + "','" + password + "') \n");
            System.out.println(f.toString());
            Statement statement = conn.createStatement();
            statement.execute(f.toString());
            System.out.println(f.toString());
            
        } catch (Exception ex) {
            ex.printStackTrace();
            intRetVal = 2;// ERROR
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e) {
                }
            }

        } finally {
            PUEntityManager.getDbManager().disconnectDatabase();
        }
        return intRetVal;

    }

    public int createCustomer(String firstName, String lastName) {
        int intRetVal = 0;
        Connection conn = null;
        try {
            conn = PUEntityManager.getDbManager().getConnection();
            String query = "";

            query += " insert into TblCustomer ( firstname,lastname) values"
                    + " ( '" + firstName + "','" + lastName + "') ";

            Statement statement = conn.createStatement();
            statement.executeUpdate(query);

            
        } catch (Exception ex) {
            ex.printStackTrace();
            intRetVal = 2;// ERROR
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e) {
                }
            }

        } finally {
            PUEntityManager.getDbManager().disconnectDatabase();
        }
        return intRetVal;

    }

    public ArrayList<Customer> findCustomers() {
        ArrayList<Customer> customers = new ArrayList<Customer>();
        Connection conn = null;
        try {
            conn = PUEntityManager.getDbManager().getConnection();
            String query = "";

            query += " select * from TblCustomer ";

            Statement statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setCustId(rs.getInt("custid"));
                customer.setFirstName(rs.getString("firstname"));
                customer.setLastName(rs.getString("lastname"));
                customers.add(customer);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e) {
                }
            }
        } finally {
            PUEntityManager.getDbManager().disconnectDatabase();
        }
        return customers;
    }

    public Customer findCustomer(String custId) {
        Customer customer = new Customer();
        Connection conn = null;
        try {
            conn = PUEntityManager.getDbManager().getConnection();
            String query = "";

            query += " select * from TblCustomer where custId =" + custId;

            Statement statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                customer.setCustId(rs.getInt("custid"));
                customer.setFirstName(rs.getString("firstname"));
                customer.setLastName(rs.getString("lastname"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e) {
                }
            }
        } finally {
            PUEntityManager.getDbManager().disconnectDatabase();
        }
        return customer;
    }

    public int updateCustomer(String custId, String firstName, String lastName) {
        int intRetVal = 0;
        Connection conn = null;
        try {
            conn = PUEntityManager.getDbManager().getConnection();
            String query = "";

            query += " update TblCustomer set firstname = '" + firstName + "' ,lastname = '" + lastName + "' "
                    + " where custId = " + custId;

            Statement statement = conn.createStatement();
            statement.executeUpdate(query);

            
        } catch (Exception ex) {
            ex.printStackTrace();
            intRetVal = 2;// ERROR
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e) {
                }
            }

        } finally {
            PUEntityManager.getDbManager().disconnectDatabase();
        }
        return intRetVal;

    }

    public int createAccount(String custId) {
        int intRetVal = 0;
        Connection conn = null;
        try {
            conn = PUEntityManager.getDbManager().getConnection();
            String query = "";

            query = "Select custId from TblAccount where custId=" + custId;
            Statement statement = conn.createStatement();
            rs = statement.executeQuery(query);
            if (rs.next()) {
                return 1;// Account already exist
            } else {
                query = " insert into TblAccount ( custId,balance) values"
                        + " ( " + custId + ",0.0) ";

                statement.executeUpdate(query);

                
                return 0;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            intRetVal = 2;// ERROR
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e) {
                }
            }

        } finally {
            PUEntityManager.getDbManager().disconnectDatabase();
        }
        return intRetVal;

    }

    public int depositAccount(String custId, double amount) {
        int intRetVal = 0;
        Connection conn = null;
        try {
            conn = PUEntityManager.getDbManager().getConnection();
            String query = "";

            query = "Select custId from TblAccount where custId=" + custId;
            Statement statement = conn.createStatement();
            rs = statement.executeQuery(query);
            if (rs.next()) {
                query = " update TblAccount set balance = balance + " + amount + " where custId=" + custId;
                statement.executeUpdate(query);
                return 0; // Deposited successfully
            } else {
                return 1;// Account does not exist
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            intRetVal = 2;// ERROR
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e) {
                }
            }

        } finally {
            PUEntityManager.getDbManager().disconnectDatabase();
        }
        return intRetVal;

    }

    public int withdrawAccount(String custId, double amount) {
        int intRetVal = 0;
        Connection conn = null;
        try {
            conn = PUEntityManager.getDbManager().getConnection();
            String query = "";

            query = "Select custId, balance from TblAccount where custId=" + custId;
            Statement statement = conn.createStatement();
            rs = statement.executeQuery(query);
            if (rs.next()) {

                double balance = rs.getDouble("balance");
                if (balance < amount) {
                    return 2;// Insufficient balance
                } else {
                    query = " update TblAccount set balance = balance - " + amount + " where custId=" + custId;
                    statement.executeUpdate(query);
                    
                    return 0; // Withdraw successfully
                }

            } else {
                return 1;// Account does not exist
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            intRetVal = 3;// ERROR
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e) {
                }
            }

        } finally {
            PUEntityManager.getDbManager().disconnectDatabase();
        }
        return intRetVal;

    }

    public int isValidUserId(String userID) {
        Connection conn = null;
        int valid = 0;
        try {

            conn = PUEntityManager.getDbManager().getConnection();

            if (conn != null) {
                stmt = conn.createStatement();
            } else {
                System.out.println("isValidUserId Valid connection is invalie");
            }
            //	System.out.println("aft conn CardValie");
            StringBuffer sf = new StringBuffer();
            sf.append("");
            sf.append("SELECT USERID         \n");
            sf.append("FROM TblTeller        \n");
            sf.append("WHERE USERID =? \n");

            pstmt = conn.prepareStatement(sf.toString());
            //pstmt = conn.prepareStatement(sf.toString());
            pstmt.setString(1, userID);
            rs = pstmt.executeQuery();

            if (rs.next() == false) {
                valid = 0;//user 
            } else {
                valid = 1;// user exist
            }

        } catch (Exception ex) {
            System.out.println("Exception:" + ex);
        } finally {
            PUEntityManager.getDbManager().disconnectDatabase();
        }
        return valid;
    }

    public int login(String userID, String password) {
        Connection conn = null;
        int valid = 0;
        try {

            conn = PUEntityManager.getDbManager().getConnection();
            // System.out.println("bef conn CardValie");

            if (conn != null) {
                stmt = conn.createStatement();
            } else {
                System.out.println("Connection Exception!");
            }
            //	System.out.println("aft conn CardValie");
            StringBuffer sf = new StringBuffer();
            sf.append("");
            sf.append("SELECT USERID         \n");
            sf.append("FROM TblTeller        \n");
            sf.append("WHERE USERID =? \n");
            sf.append("AND PASSWORD =? \n");

            pstmt = conn.prepareStatement(sf.toString());
            //pstmt = conn.prepareStatement(sf.toString());
            pstmt.setString(1, userID);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();

            if (rs.next() == false) {
                valid = 0;//user does not exist
            } else {
                valid = 1;// user exist
            }

            System.out.println("Valid User:" + valid);
        } catch (Exception ex) {
            System.out.println("Exception:" + ex);
        } finally {
            
            PUEntityManager.getDbManager().disconnectDatabase();
        }
        return valid;
    }

    /**
     *
     * @param custId1
     * @param custId2
     * @param amount
     * @return
     */
    public int transferAmount(String custId1, String custId2, double amount) {
        //ERROR CODE 0 = Successful Transaction
        //ERROR CODE 1 = Customer 1 account does not exist
        //ERROR CODE 2 = Customer 2 account does not exist
        //ERROR CODE 3 = Insufficient balance
        //ERROR CODE 4 = Exception
        Connection conn = null;
        int accountId = 0;
        int transferToAccountId = 0;
        try {
            conn = PUEntityManager.getDbManager().getConnection();

            String query = "Select accountId from TblAccount where custId=" + custId1;
            System.out.println(query);
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            if (rs.next()) {
                accountId = rs.getInt("accountId");

                query = "Select accountId from TblAccount where custId=" + custId2;
                System.out.println(query);
                rs = stmt.executeQuery(query);

                if (rs.next()) {
                    transferToAccountId = rs.getInt("accountId");

                    query = "Select balance from TblAccount where custId=" + custId1;
                    System.out.println(query);
                    rs = stmt.executeQuery(query);
                    rs.next();
                    double balance = rs.getDouble("balance");
                    if (amount <= balance) {
                        query = "Update TblAccount set balance = balance - " + amount + " where custId=" + custId1;
                        System.out.println(query);
                        stmt.executeUpdate(query);

                        query = "Insert into TblTransaction (accountId, transDate, transType, transferToAccountId, transAmount) "
                                + "VALUES ("
                                + "" + accountId + ","
                                + "now(),"
                                + "0,"
                                + "" + transferToAccountId + ","
                                + "" + amount + ""
                                + ")";
                        System.out.println(query);
                        stmt.executeUpdate(query);

                    } else {
                        return 3;
                    }
                } else {
                    return 2;
                }
            } else {
                return 1;
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Exception:" + ex);
            return 4;
        } finally {
            PUEntityManager.getDbManager().disconnectDatabase();
        }
        return 0;
    }

    /**
     *
     * @return
     */
    public ArrayList<Transaction> transactionDetails() {
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        Connection conn = null;
        try {
            conn = PUEntityManager.getDbManager().getConnection();
            String query = "";

            query += " Select TblCustomer.firstName as TransferrerFN,TblCustomer.lastName as TransferrerLN, "
                    + "TblCustomer.firstName as TransfereeFN,TblCustomer.lastName as TransfereeLN, "
                    + "TblTransaction.transDate, "
                    + "TblTransaction.transAmount "
                    + "from TblCustomer,TblTransaction,TblAccount "
                    + "where TblTransaction.accountId = TblAccount.accountId "
                    + "and TblAccount.custId = TblCustomer.custId ";

            Statement statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                Transaction transaction = new Transaction();
                transaction.setTransferer(rs.getString("TransferrerFN") + " " + rs.getString("TransferrerLN"));
                transaction.setTransferee(rs.getString("TransfereeFN") + " " + rs.getString("TransfereeLN"));
                transaction.setTransferDate(rs.getString("transDate"));
                transaction.setTransAmount(rs.getDouble("transAmount"));
                transactions.add(transaction);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e) {
                }
            }
        } finally {
            PUEntityManager.getDbManager().disconnectDatabase();
        }
        return transactions;
    }

    public ArrayList<Account> accountDetails() {
        ArrayList<Account> accounts = new ArrayList<Account>();
        Connection conn = null;
        try {
            conn = PUEntityManager.getDbManager().getConnection();
            String query = "";

            query += " Select TblCustomer.firstName ,TblCustomer.lastName , "
                    + "TblAccount.isActive, "
                    + "TblAccount.balance "
                    + "from TblCustomer,TblAccount "
                    + "where  "
                    + "TblAccount.custId = TblCustomer.custId ";

            Statement statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                Account account = new Account();
                account.setFirstName(rs.getString("firstName"));
                account.setLastName(rs.getString("lastName"));
                int status = rs.getInt("isActive");
                if (status == 0) {
                    account.setActive("Inactive");
                } else {
                    account.setActive("Active");
                }
                account.setBalance(rs.getDouble("balance"));
                accounts.add(account);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e) {
                }
            }
        } finally {
            PUEntityManager.getDbManager().disconnectDatabase();
        }
        return accounts;
    }

    public int closeAccount(String custId) {
        int intRetVal = 0;
        Connection conn = null;
        try {
            conn = PUEntityManager.getDbManager().getConnection();
            String query = "";

            query = "update TblAccount set isActive = 0 where custId=" + custId;
            Statement statement = conn.createStatement();

            statement.executeUpdate(query);
            
            return 0; // Closed

        } catch (Exception ex) {
            ex.printStackTrace();
            intRetVal = 1;// ERROR
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e) {
                }
            }

        } finally {
            PUEntityManager.getDbManager().disconnectDatabase();
        }
        return intRetVal;
    }
}
