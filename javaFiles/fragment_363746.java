Configuration cfg = new Configuration();
    cfg.configure();

    SessionFactory factory = cfg.buildSessionFactory();

    Session session = factory.openSession();