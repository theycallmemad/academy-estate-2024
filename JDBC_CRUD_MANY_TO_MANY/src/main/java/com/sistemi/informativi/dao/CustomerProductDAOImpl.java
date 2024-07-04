package com.sistemi.informativi.dao;

import com.sistemi.informativi.connection.ConnectionManager;
import com.sistemi.informativi.dto.CustomerProductDTO;
import com.sistemi.informativi.sql.SqlScript;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerProductDAOImpl implements CustomerProductDAO {


    @Override
    public void addCustomerProduct(CustomerProductDTO customerProductDTO) throws ClassNotFoundException, SQLException {

        PreparedStatement ps = ConnectionManager.getPreparedStatement(SqlScript.sqlJoinTableInsert);

        ps.setInt(1,customerProductDTO.getCustomer_id());

        ps.setInt(2,customerProductDTO.getProduct_id());

        ps.executeUpdate();



    }
}
