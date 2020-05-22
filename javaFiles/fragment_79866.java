Session session = HibernateUtilities.openSession();
        session.beginTransaction();


        List<Post> usersFeed = session.createQuery("select p from Post p where p.mUserId = :userId")
                  .setString("userId", userId)
                  .list();


        session.getTransaction().commit();
        session.close();