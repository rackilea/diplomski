Session session = sessionFactory.openSession();
session.addEventListeners(new BaseSessionEventListener() {
    @Override
    public void jdbcExecuteStatementStart() {
        DbTaskThread.requireDbTaskThread();
        super.jdbcExecuteStatementStart();
    }

    @Override
    public void jdbcConnectionReleaseStart() {
        DbTaskThread.requireDbTaskThread();
        super.jdbcConnectionReleaseStart();
    }

    @Override
    public void jdbcConnectionAcquisitionStart() {
        DbTaskThread.requireDbTaskThread();
        super.jdbcConnectionAcquisitionStart();
    }
});