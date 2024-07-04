package com.sistemi.informativi.dao;

import com.sistemi.informativi.connection.ConnectionManager;
import com.sistemi.informativi.dto.CourseDTO;
import com.sistemi.informativi.sql.SqlScript;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseDAOImpl implements CourseDAO{


    @Override
    public int addCourse(CourseDTO courseDTO) throws SQLException, ClassNotFoundException {

        int id=1;

        //SqlScript.sqlCourseInsert = "insert into course(title)values(?)
        PreparedStatement ps = ConnectionManager.getPreparedStatement(SqlScript.sqlCourseInsert);
        ps.setString(1,courseDTO.getTitle());

        ps.executeUpdate();

        /*
        è un metodo che restituisce la chiave
        il metodo getGeneratedKeys (metodo di API)
        restituisce una Struttura Dati JDBC contenente
        una sola locazione di memoria che contiene il
        riferimetno ad
         */
        ResultSet rs = ps.getGeneratedKeys();

        if(rs.next()){
            id = rs.getInt(1);


        }

        return id;

    }

    @Override
    public void removeCourse(int id) throws SQLException, ClassNotFoundException {

        //SqlScript.sqlDeleteCourse = "delete from course where id=?"
        PreparedStatement ps = ConnectionManager.getPreparedStatement(SqlScript.sqlDeleteCourse);

        ps.setInt(1,id);

        ps.executeUpdate();

    }



}
