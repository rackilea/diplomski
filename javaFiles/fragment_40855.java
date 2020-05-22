EntityManager em = // get entity manager from entity manager factory
        em.getTransaction().begin();

        HashSet accounts  = new HashSet();
        accounts.add(new Long(10000));
        accounts.add(new Long(10001));
        accounts.add(new Long(10002));

       DefaultAccount account  =  new DefaultAccount("test@test.com", "test", accounts);
       em.persist(account);

        em.getTransaction().commit();
        em.close();