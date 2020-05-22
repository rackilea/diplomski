try {
    sess.getTransaction().begin();

    // do some work

    sess.getTransaction().commit()
}
catch (RuntimeException e) {
    sess.getTransaction().rollback();
    throw e;
}