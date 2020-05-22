ArrayList<MyClass1> obj1 = new ArrayList<MyClass1>();
ArrayList<MyClass2> obj2 = new ArrayList<MyClass2>();

ArrayList<Getable> obj3 = new ArrayList<Getable>();

obj3.add(obj1); 
obj3.add(obj2);

for (int = 0 ; i < obj3.size() ; i++) {
   Getable objGetable = obj3.get(i);
   objGetable.getAttrbiute();
 }