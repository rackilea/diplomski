List<Person> list = ArrayList<Person>();

for(int i = 0; i < arrNames.length; i++){
   Person person = new Person();
   person.setId(i + 1);
   person.setName(arrNames[i]);
   person.setLastname(arrLastnames[i]);
   person.setIdentifier(arrIds[i]);
   person.setAddress(arrAddreses[i]);

   list.add(person); // adding each person object to the list.
}