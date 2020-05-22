List<Foo> list = new ArrayList<Foo>();    
Foo tmp = new Foo();

for (int i = 0; i < 3; i++) {
  tmp.setValue(i);
  list.add(tmp);
}