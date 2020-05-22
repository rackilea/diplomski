Map<String, Person> hm = new HashMap<String, Person>();

hm.put("A", new Person("p1"));
hm.put("B", new Person("p2"));
hm.put("C", new Person("p3"));
hm.put("D", new Person("p4"));
hm.put("E", new Person("p5"));

Set<Map.Entry<String, Person>> set = hm.entrySet();

for (Map.Entry<String, Person> me : set) {
  System.out.println("Key :"+me.getKey() +" Name : "+ me.getValue().getName()+"Age :"+me.getValue().getAge());

}