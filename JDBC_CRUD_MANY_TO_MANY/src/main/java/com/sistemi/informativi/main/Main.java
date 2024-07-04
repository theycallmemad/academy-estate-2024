package com.sistemi.informativi.main;

import com.sistemi.informativi.dao.FacadeDAO;
import com.sistemi.informativi.dao.FacadeDAOImpl;
import com.sistemi.informativi.dto.CustomerDTO;
import com.sistemi.informativi.dto.CustomerProductDTO;
import com.sistemi.informativi.dto.ProductDTO;

import java.sql.Connection;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        FacadeDAO facadeDAO = new FacadeDAOImpl();

        Connection con =facadeDAO.getConnection();

        // 2 inserimenti nella tabella customer
        int customerid1 = facadeDAO.addCustomer(new CustomerDTO("Gioele", "gmarin@gmail.com"));

        int customerid2 = facadeDAO.addCustomer(new CustomerDTO("Teresa", "tproto@libero.it"));

        // 2 inserimetni nella tabella product

        int productid1 = facadeDAO.addProduct(new ProductDTO("Smarphone", 899.50f));
        int productid2 = facadeDAO.addProduct(new ProductDTO("TV", 500.50f));

        /*
        creazione associazioni nella join table (customer_product)

        customerid1, productid1
        customerid1, productid2
        customerid2, productid1
        customerid2, productid2
         */

        facadeDAO.addCustomerProduct(new CustomerProductDTO(customerid1, productid1));
        facadeDAO.addCustomerProduct(new CustomerProductDTO(customerid1, productid2));
        facadeDAO.addCustomerProduct(new CustomerProductDTO(customerid2, productid1));
        facadeDAO.addCustomerProduct(new CustomerProductDTO(customerid2, productid2));

        //test query di Join
        facadeDAO.getCustomerNameByProduct(productid1).
                forEach(customer->System.out.println(customer.getName()));

    }
}