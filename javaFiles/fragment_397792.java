public static void stopConnectionProvider() {
    final SessionFactoryImplementor sessionFactoryImplementor = (SessionFactoryImplementor) sessionFactory;
    ConnectionProvider connectionProvider = sessionFactoryImplementor.getConnectionProvider();
    if (Stoppable.class.isInstance(connectionProvider)) {
        ((Stoppable) connectionProvider).stop();
    }        
}