Session ses = HibernateUtil.getSessionFactory().openSession();
      String query = "from RegisterPojo rp where rp.email = :emailAddress and rp.pwd = :password";
      List<RegisterPojo> list = ses.createQuery(query)
      .setParameter("emailAddress", Your email address)
      .setParameter("password", Your password)
      .list();
      ses.close();