EntityManager em = emf.createEntityManager();
        Loaner current = (Loaner) getItems().getRowData();

        utx.begin();
        Loaner s = em.find(Loaner.class, current.getLoanerId());
        Loaner tmp = em.merge(s);
        em.remove(tmp);
        em.joinTransaction(); // <-- This is the fix
        em.flush(); // <-- after flushing the state of persistent entities is synchronized to the database
        utx.commit();