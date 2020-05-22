private void add2Arrays(List<Person> list) {
  for(int i = 0; i < list.size(); i++) {
    Person p = list.get(i);
    stringarray[i] = p.getName();
    intarray[i] = p.getAge();
  }
}