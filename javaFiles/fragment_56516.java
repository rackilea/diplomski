SessionImplementor session = (SessionImplementor) sessionFactory.getCurrentSession();
    IsolationDelegate isolationDelegate = session.getTransactionCoordinator().createIsolationDelegate();
    isolationDelegate.delegateWork(new AbstractWork() {
        @Override
        public void execute(Connection connection) throws SQLException {
            // This will run on a separate connection with the current
            // transaction suspended (if necessary)
        }
    }, false);