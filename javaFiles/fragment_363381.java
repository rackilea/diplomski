package com.schoolmanager.postgres.type.enumeration;

 import org.hibernate.HibernateException;
 import org.hibernate.engine.spi.SessionImplementor;

 import java.sql.PreparedStatement;
 import java.sql.SQLException;
 import java.sql.Types;

 public class EnumerationType extends org.hibernate.type.EnumType {

     public void nullSafeSet(
        PreparedStatement st,
        Object value, 
        int index,
        SessionImplementor session)
              throws HibernateException, SQLException {
         if (value == null) {
             st.setNull(index, Types.OTHER);
         } else {
             st.setObject(index, value.toString(), Types.OTHER);
         }
     }

 }