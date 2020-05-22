for (int i=0; i<twitterTrendsJPAs.size(); i++) {
    EntityManager em = EMF.get().createEntityManager();
    try {
        System.out.println("=> " + i + " - " + twitterTrendsJPAs.get(i).toString());
        em.persist(twitterTrendsJPAs.get(i)); // store current one

    } finally {
        if (em != null)
            em.close();
    }
}