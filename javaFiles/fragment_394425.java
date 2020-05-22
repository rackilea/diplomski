class MyPeople implements Iterable<Person> {
   List<Person> personList = new ArrayList<Person>();

   // ... other methods and constructor

   @Override
   public Iterator<Person> iterator() {
      return personList.iterator();
   }
}