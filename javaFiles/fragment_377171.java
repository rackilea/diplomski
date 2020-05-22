Session session = entityManager.unwrap(Session.class);
SessionFactoryImplementor sessionFactoryImplementation = (SessionFactoryImplementor) session.getSessionFactory();
ConnectionProvider connectionProvider = sessionFactoryImplementation.getConnectionProvider();
try {
       connection = connectionProvider.getConnection();
       PreparedStatement ps = connection.prepareStatement("SELECT 1 FROM Location WHERE id <> ? AND locationName = ?");
       ps.setLong(1, id);
       ps.setString(2, checkedValue);
       ResultSet rs = ps.executeQuery();
       boolean result = rs.next();//found any results? if we can retrieve a row: yes!
       rs.close();
       return result;
}//catch SQLException etc... 
//finally, close resources (only the resultset!)