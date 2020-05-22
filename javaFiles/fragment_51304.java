System.out.println("Try to store into database...");
EntityManager em = EMF.get().createEntityManager();
    try {
        for (int i=0; i<twitterTrendsJPAs.size(); i++) {
            System.out.println("=> " + i + " - " + twitterTrendsJPAs.get(i).toString());
            em.getTransaction().begin();
            em.persist(twitterTrendsJPAs.get(i)); // store current one
            em.getTransaction().commit();
        }
    } finally {
        em.close();
    }
System.out.println("wow. Finished.");