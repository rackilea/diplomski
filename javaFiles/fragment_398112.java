em.getTransaction().begin();
//first create B.
B bb = new B();
bb.setId(1);
bb.setName("CC");
// no need to persist bb.

//create A with B set in it.
A aa = new A();
aa.setId(1);
aa.setName("JJ");
aa.setB(bb);
em.persist(aa); // because of cascade all , when you persist A ,
// B will also be persisted.
em.getTransaction().commit();