private boolean isTestDb(Session session) {
    return session.doReturningWork(new ReturningWork<Boolean>() {
        @Override
        public Boolean execute(Connection connection) throws SQLException {
            DatabaseMetaData metaData = connection.getMetaData();
            return metaData.getDatabaseProductName().startsWith("HSQL");
        }
    });
}