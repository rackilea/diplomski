compareFirstName c = new compareFirstName ();
List<Person> yourPersonList = new ArrayList<>();
.........................
Collections.sort(yourPersonList, c);
for(Person p : yourPersonList) {
  System.out.println(p.getFirstName()+","+p.getLastName()+","+p.getAge());
}