@Override
   public int compare(Person o1, Person o2) {
       return 0;
   }

   Person one = new Person("Kevin", "Gresmer");
   List<Person> persons = new ArrayList<Person>();

   private void addPersons(){
     persons.add(one);
   }
                  //persons.add(one);

   public void sortByLastName(List people) {
       addPersons();
       Comparator comp = new PersonComparator();
       Collections.sort(people, comp);
   }
}