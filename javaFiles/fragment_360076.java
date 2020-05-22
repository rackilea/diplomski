public TimezoneEnabledDataSource extends BasicDataSource {
    private String timezone;
    //getter and setter for it

    @Override    
    public Connection getConnection() {
        Connection c = super.getConnection();
        // execute a query: SET time_zone = '-8:00'
        return c;
    }
}