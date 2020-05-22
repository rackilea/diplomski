private Connection getConnection() {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationContextConfiguration.class);
    ComboPooledDataSource comboPooledDataSource = ctx.getBean(ComboPooledDataSource.class);
    try {
        return comboPooledDataSource.getConnection();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}