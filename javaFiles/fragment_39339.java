catch (HibernateException ex) {

        Throwable cause = ex.getCause();
        if (cause instanceof SQLException) {
            System.out.println(cause.getMessage());
        }
 }