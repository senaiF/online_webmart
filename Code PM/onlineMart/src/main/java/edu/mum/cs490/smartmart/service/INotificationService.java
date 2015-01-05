/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.service;

import edu.mum.cs490.smartmart.domain.Admin;
import edu.mum.cs490.smartmart.domain.Customer;
import java.util.List;

/**
 *
 * @author Senai
 */
public interface INotificationService {

    
    public void notifyCustomer(Customer customer, String message) ;

    public void contactAdmin(Admin admin, String message);

}
