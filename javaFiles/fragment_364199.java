public Person getById(int id){
    Session session = sessionFactory.openSession(); 
    try {
      return (Person) session.get(Person.class, id);
    } finally {
      session.close();
    }    
}