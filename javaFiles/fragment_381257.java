transactionTemplate.execute(new TransactionCallbackWithoutResult() {
        @Override
        protected void doInTransactionWithoutResult(TransactionStatus status) {
            em.createNativeQuery("TRUNCATE TABLE MyTable).executeUpdate();
        }
    });