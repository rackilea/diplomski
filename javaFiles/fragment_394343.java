@Bean(initMethod = "init", destroyMethod = "close")
public UserTransactionManager atomikosTransactionManager() {
    UserTransactionManager userTransactionManager = new UserTransactionManager();
    userTransactionManager.setForceShutdown(false);

    return userTransactionManager;
}

@Bean
public UserTransaction atomikosUserTransaction() throws SystemException {
    UserTransactionImp userTransaction = new UserTransactionImp();
    userTransaction.setTransactionTimeout(300);

    return userTransaction;
}

@Bean
public PlatformTransactionManager platformTransactionManager() throws SystemException {
    JtaTransactionManager jtaTransactionManager = new JtaTransactionManager();

    jtaTransactionManager.setTransactionManager(atomikosTransactionManager());
    jtaTransactionManager.setUserTransaction(atomikosUserTransaction());
    jtaTransactionManager.setAllowCustomIsolationLevels(true);

    return jtaTransactionManager;
}