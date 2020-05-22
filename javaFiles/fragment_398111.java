em.getTransaction().begin();
//first create B.
B bb = new B();
bb.setId(1);
bb.setName("CC");
em.persist(bb);

//create A with B set in it.
A aa = new A();
aa.setId(1);
aa.setName("JJ");
aa.setB(bb);
em.persist(aa);
em.getTransaction().commit();