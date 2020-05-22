public void getSelectList(String query, 
    Consumer<List> succeededHandler, 
    Consumer<Exception> errorHandler) {

    FutureTask<List> futureTask = new FutureTask<>(() -> {

        Session session = sessionFactory.getSession();
        try {
            session.beginTransaction();
            List list = session.createQuery(query).list();
            session.getTransaction().commit();
            return list ;
       } catch (Exception e) {
            Transaction tx = session.getTransaction();
            if (tx != null) {
                tx.rollback();
            }
            throw e ;
       }
    });

    Thread thread = new Thread(futureTask);
    thread.setDaemon(true);
    thread.start();

    try {
        List list = futureTask.get();
        succeededHandler.accept(list);
    } catch (Exception e) {
        errorHandler.accept(e);
    }
}