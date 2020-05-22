abstract class TransactionalQuery {

    void execute() {
        EntityManager manager = createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = manager.getTransaction();
            transaction.begin();
            // Do my transaction.
            transaction(manager);

            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            manager.close();
        }
    }

    protected abstract void transaction(EntityManager manager);
}

private void deleteEmployee(Integer code) {
    new TransactionalQuery() {
        @Override
        protected void transaction(EntityManager manager) {
            //useful part:
            Employee employee = manager.find(Employee.class, code);
            manager.remove(employee);
        }
    }.execute();
}

private Integer addEmployeeToDB(String fname, String lname, int salary) {
    // Using an AtomicInteger as a Mutable Integer - not good practice.
    final AtomicInteger id = new AtomicInteger();
    new TransactionalQuery() {
        @Override
        protected void transaction(EntityManager manager) {
            //here is useful part
            Employee employee = new Employee(fname, lname, salary);
            manager.persist(employee);
            id.set(employee.getId());
        }
    }.execute();
    return id.get();
}