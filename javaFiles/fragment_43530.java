class DriverShim implements Driver {
    private Driver driver;
    DriverShim(Driver d) { this.driver = d; }
    public boolean acceptsURL(String u) throws SQLException {
        return this.driver.acceptsURL(u);
    }
    public Connection connect(String u, Properties p) throws SQLException {
        return this.driver.connect(u, p);
    }
    // and so on....