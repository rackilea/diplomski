SqlMapClientCallback<Integer> callback = new SqlMapClientCallback<Integer>() {
        public Integer doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
            executor.startBatch();
            //... do your queries here
            return executor.executeBatch();
        }
    };