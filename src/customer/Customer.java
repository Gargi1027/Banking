/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer;

import java.io.Serializable;

/**
 *
 * @author My PC
 */
public class Customer implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int custId;
    private String firstName;
    private String lastName;

    public Customer() {
    }

    public Customer(int custId, String firstName, String lastName) {
        this.custId = custId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    
}
