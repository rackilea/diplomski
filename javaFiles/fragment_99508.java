package com.xyz;

import java.io.Serializable;
import java.sql.*;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class IdGenerator implements IdentifierGenerator{

    @Override
    public Serializable generate(SessionImplementor session, Object object)
            throws HibernateException {


        Connection connection = session.connection();

        try {
            Statement statement=connection.createStatement();

            ResultSet rs=statement.executeQuery("select count(Id) from dbo.TableName");

            if(rs.next())
            {
                int id=rs.getInt(1);
                return new Integer(id).toString();
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }

}