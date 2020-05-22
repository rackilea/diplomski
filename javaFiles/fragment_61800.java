Person person = new Person();
Event event1 = new Event();
Event event2 = new Event();

person.getEvents().add(event1);
person.getEvents().add(event2);

event1.setPerson(person);
event2.setPerson(person);

// Start transaction here 
entityManager.persist(person); // this should save also events because of cascade attribute
// commit transaction