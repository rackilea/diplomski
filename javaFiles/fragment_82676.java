Person person1 = new Person();
Person person2 = new Person();

Trip mn1Trip1 = new Trip("MN", 1, person1);
Trip wi1Trip1 = new Trip("WI", 1, person1);
Trip nd2Trip1 = new Trip("ND", 2, person1);
Trip mt2Trip1 = new Trip("MT", 2, person1);
Trip ia1Trip2 = new Trip("IA", 1, person2);
// more than one trip by a person goes to the same state
Trip mn2Trip1 = new Trip("MN", 2, person1);
Trip ia2Trip2 = new Trip("IA", 2, person2);
Trip mn1Trip2 = new Trip("MN", 1, person2);

person1.setTrips(Arrays.asList(mn1Trip1, wi1Trip1, nd2Trip1, mt2Trip1, mn2Trip1));
person2.setTrips(Arrays.asList(ia1Trip2, ia2Trip2, mn1Trip2));

em.getTransaction().begin();
em.persist(person1);
em.persist(person2);
em.getTransaction().commit();