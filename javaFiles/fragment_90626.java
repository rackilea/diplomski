for (Object object : listClsObj) {
    int cnt = 1;
    do {
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
        em.detach(object);
        ((Person)object).setId(null);
        cnt++;
    }
    while (cnt < 6);
        }
em.close();