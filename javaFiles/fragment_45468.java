Person person = new Person();                         
person.setFirstname("Dave");                          

Example<Person> example = Example.of(person); 

MongoRepository repo = …
List<Person> result = repo.findAll(example); // returns all objects that with Dave in firstname