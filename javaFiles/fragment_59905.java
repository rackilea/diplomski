List<Foo> list = new ArrayList<Foo>();        

for (int i = 0; i < 3; i++) {
  Foo tmp = new Foo(); // <-- fresh instance!
  tmp.setValue(i);
  list.add(tmp);
}