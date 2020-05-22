@RequestScoped public class EmployeeDAOImpl implements IGenericDAO<Employee> {

@Override
public void save(Employee Employee) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;
    try {
        transaction = session.beginTransaction();
        session.save(Employee);
        transaction.commit();
    } catch (Exception e) {
        if (transaction != null)
            transaction.rollback();
        throw e;
    } finally {
        session.close();
        HibernateUtil.getSessionFactory().close();
    }
}

@Override
public void update(Employee Employee) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;
    try {
        transaction = session.beginTransaction();
        session.update(Employee);
        transaction.commit();
    } catch (Exception e) {
        if (transaction != null)
            transaction.rollback();
        throw e;
    } finally {
        session.close();
        HibernateUtil.getSessionFactory().close();
    }
}

@Override
public Employee getObjectById(int id) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    try {
        return (Employee) session.createCriteria(Employee.class).add(Restrictions.eq("id", id)).list().get(0);
    } catch (Exception e) {
        throw e;
    } finally {
        session.close();
        HibernateUtil.getSessionFactory().close();
    }
}

@SuppressWarnings("unchecked")
@Override
public List<Employee> getAll() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    try {
        return session.createCriteria(Employee.class).list();
    } catch (Exception e) {
        throw e;
    } finally {
        session.close();
        HibernateUtil.getSessionFactory().close();
    }
}