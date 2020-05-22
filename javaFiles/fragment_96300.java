DataSource ds = (DataSource)ctx.getBean("dataSourceBean");
try {
    Connection con =ds.getConnection();
    con.setAutoCommit(false);
    System.out.println("Autocommit " +con.getAutoCommit());
} catch (SQLException e) {          
    e.printStackTrace();
}