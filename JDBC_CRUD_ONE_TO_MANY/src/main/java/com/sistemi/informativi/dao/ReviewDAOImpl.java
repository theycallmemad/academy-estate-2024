package com.sistemi.informativi.dao;

import com.sistemi.informativi.connection.ConnectionManager;
import com.sistemi.informativi.dto.ReviewDTO;
import com.sistemi.informativi.sql.SqlScript;
import com.sistemi.informativi.vo.ReviewVO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReviewDAOImpl implements ReviewDAO{

    @Override
    public void addReview(ReviewDTO reviewDTO) throws SQLException, ClassNotFoundException {

        PreparedStatement ps = ConnectionManager.getPreparedStatement(SqlScript.sqlReviewInsert);
        ps.setString(1,reviewDTO.getLocation());
        ps.setInt(2, reviewDTO.getCourseId());

        ps.executeUpdate();

    }

    @Override
    public ArrayList<ReviewVO> getReviewLocationsByCourse(int courseId) throws SQLException, ClassNotFoundException {

        /*
        inizializzazione di un ArrayList che conterrà
        oggetti ReviewVO serializzati. ogni oggetto
        VO sarà una copia dell'Oggetto originale del
        ResultSet (non serializzato)
         */
        ArrayList<ReviewVO> reviews = new ArrayList<>();

        ReviewVO reviewVO = null;

        /*
        Qaundo occorre eseguire delle query(operazioni di lettura) parametriche
        è necessario utilizzare l'Oggetto PreparedStatement in quanto occorrre sostituire
        concretamente i placeholder, e lo si può fare solo tramite l'API PreapredStatement
        che rende possibile conretizzare i placeholder tramite i metodi di set
        (l'API Statement non ha i metodi di set, per cui non è utilizzabile per sostituire
        i placeholder in una query parametrica)

        BEST PRACTICE:
        - utilizzare l'API Statement per query che non contengono parametri (letture integrali(senza where))
        -utilizzare l'API Prepared Statement per query parametriche
         */
    PreparedStatement ps = ConnectionManager.getPreparedStatement(SqlScript.sqlReviewsLocationByCourse);

    ps.setInt(1, courseId);
    //query concretizzata senza placeholder ma con un valore reale courseId passato in input al metodo


        /*
        invocando il metodo executeQuery su un PreparedStatement già concreto
        si ricava un ResultSet contenente già i risultati della lettura
         */
        ResultSet rs = ps.executeQuery();

        while(rs.next()){

            reviewVO = new ReviewVO(rs.getString("location"));

            reviews.add(reviewVO);

        }

        return reviews;

    }
}
