x = new Foo();
y = new Foo();

em.persist(x);
Foo z = em.merge(y);

//x is associated with the persistence context
//y is NOT associated with the persistence context
//z is associated with the persistence context