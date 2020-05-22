tx.begin();
Person p = new Person();
PersonName c1 = new PersonName(p, "F1", "M1", "L1"); 
PersonName c2 = new PersonName(p, "F2", "M2", "L2"); 
em.persist(p);
em.persist(c1);
em.persist(c2);
tx.commit();