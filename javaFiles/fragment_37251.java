ExampleClass& doSomething(ExampleClass* ec) {
  // note ec of is type ExampleClass*
  // *ec is of type ExampleClass
  return *ec; // returns a reference to whatever the pointer points to
}
ExampleClass * pointer = new ExampleClass();
ExampleClass& myobj = doSomething(pointer);