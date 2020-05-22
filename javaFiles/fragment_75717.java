public static Connection getConnection() throws Exception {
    if (dataSource == null) {          // Another thread can come in after this
        initDataSource();              // and before this
    }
    return dataSource.getConnection();
}