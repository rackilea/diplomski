void myMethod(Class<T> aReceived) {
  T newObject = aReceived.getConstructor(String.class, int.class)
      .newInstance("aaa", 222);  
  ...
  // Sadly, due to erasure of generics you cannot do newObject.SomeMethodOfT() 
  // because T is effectively erased to Object. You can only invoke the 
  // methods of Object and/or use refelection to dynamically manipulate newObject
}