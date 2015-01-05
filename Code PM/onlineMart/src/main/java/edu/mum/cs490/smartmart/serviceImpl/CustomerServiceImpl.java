/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.serviceImpl;


import edu.mum.cs490.smartmart.domain.Role;
import edu.mum.cs490.smartmart.dao.ICredentialDAO;
import edu.mum.cs490.smartmart.dao.ICustomerDAO;
import edu.mum.cs490.smartmart.domain.Credential;
import edu.mum.cs490.smartmart.domain.Customer;
import edu.mum.cs490.smartmart.domain.Users;
import edu.mum.cs490.smartmart.service.ICustomerService;
import edu.mum.cs490.smartmart.service.IEncryptionService;
import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Komal
 */
public class CustomerServiceImpl implements ICustomerService {

    ICustomerDAO customerDAO;

    IEncryptionService encryptionService;
    
    private ICredentialDAO credentialDAO;

    public ICustomerDAO getCustomerDAO() {
        return customerDAO;
    }

    public void setCustomerDAO(ICustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public IEncryptionService getEncryptionService() {
        return encryptionService;
    }

    public void setEncryptionService(IEncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }

    public ICredentialDAO getCredentialDAO() {
        return credentialDAO;
    }

    public void setCredentialDAO(ICredentialDAO credentialDAO) {
        this.credentialDAO = credentialDAO;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void addCustomer(Customer customer) {
        customer.getCredential().setPassword(encryptionService.getEncryptedPassword(customer.getCredential().getPassword()));
        customer.getCredential().setRole(Role.CUSTOMER);
        customerDAO.save(customer);
    }
    
       @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean checkUserName(String userName) {
        Credential cred=new Credential();
        cred.setUsername(userName);
        if (credentialDAO.findByExample(cred,new String[]{}) != null) {
            return true;
        }
        return false;
    }

    @Override
    public Customer getCustomerById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Customer> getAllCustomers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void disableCustomer(Customer customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateCustomer(int id, Customer customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Users getUserByUsername(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void notifyCustomer(Customer customer, String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
