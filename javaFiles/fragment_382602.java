public <T> List<T> loadAllData(Class<T> type)
{
        // New session was opened here
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(type);
        criteria.from(type);
        List<T> data = session.createQuery(criteria).getResultList();

        session.getTransaction().commit();
        session.close();
        //session is close here
        return data;
    }