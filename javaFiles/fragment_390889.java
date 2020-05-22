MyClass myClass1 = new MyClass<Integer>();
//MyClass<Object> myClass2 = new MyClass<Integer>();//compilation error
  MyClass<?> myClass3 = new MyClass<Integer>();//this time it compiles

  myClass1.setter(1);
//myClass3.setter(1);//compilation error