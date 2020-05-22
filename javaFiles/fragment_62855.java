entityManager.getTransaction().begin();
Person p = new Person();
p.friends.add(new Person());
p.friends.add(new Person());
p.friends.add(new Person());
p.friends.add(new Person());
entityManager.persist(p);
entityManager.getTransaction().commit();