try {
    InitialContext ic = new InitialContext();
    return (DataSource) ic.lookup("java:comp/env/MySQLDB");
} catch (NamingException e) {
    logger.error("JNDI error while retrieving datasource" , e);
    throw new Exception(e);
}