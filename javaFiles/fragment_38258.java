public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session) throws HibernateException, SQLException {

    if (logger.isTraceEnabled()) {
        logger.trace("  nullSafeSet: " + value + ", ps: " + st + ", index: " + index);
    }
    try {
        XMLType xmlType = null;
        if (value != null) {
            xmlType = XMLType.createXML(getOracleConnection(st.getConnection()), (String)value);
        }
        st.setObject(index, xmlType);
    } catch (Exception e) {
        throw new SQLException("Could not convert String to XML for storage: " + (String)value);
    }
}