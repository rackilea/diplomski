entityManager.getTransaction().begin();
UnitOfWork unitOfWork = (UnitOfWork)((JpaEntityManager)entityManager.getDelegate()).getActiveSession();
unitOfWork.beginEarlyTransaction();
Accessor accessor = unitOfWork.getAccessor();
accessor.incrementCallCount(unitOfWork.getParent());
accessor.decrementCallCount();
java.sql.Connection connection = accessor.getConnection();
...
entityManager.getTransaction().commit();