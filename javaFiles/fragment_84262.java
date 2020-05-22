List<Product> listProductIds = jdbc.execute(
    "{ call find_Product_id(?,?,?,?,?) }",
    new CallableStatementCallback<List<Product>>() {
        public List<Product> doInCallableStatement(CallableStatement callableStatement) throws SQLException, DataAccessException {
            ....
        }
    }
);