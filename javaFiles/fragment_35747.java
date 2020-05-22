List<Person> filtered = Lists.newArrayList();
for(Person p : allPersons) {
   if(acceptedNames.contains(p.getName())) {
       filtered.add(p);
   }
}