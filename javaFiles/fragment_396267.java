SessionFactory sf = // get your session factory
Query q = sf.getCurrentSession()
        .createQuery(hqlQuery);
q.setParameter("minDate",minDate.getTime())
 .setParameter("app", appId)
 .list();