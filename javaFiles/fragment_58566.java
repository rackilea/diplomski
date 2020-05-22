SessionFactory sf = new Configuration().configure("trial.cfg.xml")
                                       .buildSessionFactory();
    Session session = sf.openSession();
    //load the object before deleting
    Dept department = session.get(Dept.class, new Integer(2));
    session.delete(department);
    session.flush();
    session.close();