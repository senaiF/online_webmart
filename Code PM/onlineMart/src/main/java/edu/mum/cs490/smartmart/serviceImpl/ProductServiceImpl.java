/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.serviceImpl;

import edu.mum.cs490.smartmart.dao.ProductCategoryDAO;
import edu.mum.cs490.smartmart.dao.ProductDAO;
import edu.mum.cs490.smartmart.dao.VendorDAO;
import edu.mum.cs490.smartmart.domain.Product;
import edu.mum.cs490.smartmart.domain.ProductCategory;
import edu.mum.cs490.smartmart.domain.Users;
import edu.mum.cs490.smartmart.domain.Vendor;
import edu.mum.cs490.smartmart.service.ProductService;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Kabiraj
 */
public class ProductServiceImpl implements ProductService {

    private ProductDAO productDAO;
    private ProductCategoryDAO productCategoryDAO;
    private VendorDAO vendorDAO;

    public ProductDAO getProductDAO() {
        return productDAO;
    }

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public VendorDAO getVendorDAO() {
        return vendorDAO;
    }

    public void setVendorDAO(VendorDAO vendorDAO) {
        this.vendorDAO = vendorDAO;
    }
    
    

    public ProductCategoryDAO getProductCategoryDAO() {
        return productCategoryDAO;
    }

    public void setProductCategoryDAO(ProductCategoryDAO productCategoryDAO) {
        this.productCategoryDAO = productCategoryDAO;
    }
    
    
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void addProduct(Product product) {
      
        
      try{
           productDAO.save(product);  
           
        }catch(Exception e){
            
        }
    }

    @Override
    public List<Product> getAllProducts() {
        
        List<Product> products= productDAO.findAll(0, 10);
        return products;

    }

    @Override
    public List<ProductCategory> getListOfCategory() {
        
        List<ProductCategory> categories= productCategoryDAO.findAll(0, 10);
        return categories;
    }

    @Override
    public List<Vendor> getListOfVendor() {
        
        List<Vendor> vendors=vendorDAO.findAll(0, 10);
        return vendors;
        
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Product getProduct(long id) {
       try{
           return productDAO.findByPrimaryKey(id);
        }catch(Exception e){
            return null;
        }
    }
    
    
    
}