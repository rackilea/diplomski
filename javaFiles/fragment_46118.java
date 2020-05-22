EntityManagerFactory emFactory = em.getEntityManagerFactory();
    SessionFactory sessionFactory = emFactory.unwrap(SessionFactory.class);
    Session session = sessionFactory.openSession();
    Transaction txn = session.beginTransaction();

    String query = "insert into user (email,password,name,tenant) values(?,?,?,?)";
    session.createSQLQuery(query).setParameter(0, newUser.getCredenciais().getEmail())
    .setParameter(1, newUser.getCredenciais().getPassword()).setParameter(2, newUser.getName())
    .setParameter(3, newUser.getTenant()).executeUpdate();

    BigInteger result = (BigInteger) session.createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult();

    txn.commit();
    session.close();