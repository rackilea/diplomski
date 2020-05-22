@Override
public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner)
        throws HibernateException, SQLException {
     String name = rs.getString(names[0]);  
        Object result = null;  
        if (!rs.wasNull()) {  
            result = Enum.valueOf(clazz, name);  
        }  
        return result;
}

@Override
public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session)
        throws HibernateException, SQLException {
    if (null == value) {  
        st.setNull(index, Types.VARCHAR);  
    } else {  
        st.setString(index, ((Enum<E>) value).name());  
    }  

}