new TransactionTemplate(transactionManager).execute(new TransactionCallback(){
    public void doInTransaction(TransactionStatus ts){
        // run your code here...use the dataSource to get a connection and run stuff
        Connection c = dataSourceProxy.getConnection();
        // to rollback ... throw a RuntimeException out of this method or call 
        st.setRollbackOnly();
    }
});