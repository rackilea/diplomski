} catch (HibernateException e) {
    if (tx != null) {
        try {
            tx.rollback();
        } catch(Exception re) {
            System.err.println("Error when trying to rollback transaction:"); // use logging framework here
            re.printStackTrace();
        }
    }
    System.err.println("Original error when executing query:"); // // use logging framework here

    e.printStackTrace();
}