public static synchronized Connection getConnection() throws Exception {
// -----------^
    if (dataSource == null) {          // Now this region is
        initDataSource();              // protected
    }
    return dataSource.getConnection();
}