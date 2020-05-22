String hql="update table set id=? where id=? ";
Query query=HibernateSessionFactory.getSession().createQuery(hql);
query.setInteger(0,1);
query.setInteger(1,2);
query.executeUpdate();
HibernateSessionFactory.getSession().beginTransaction().commit();