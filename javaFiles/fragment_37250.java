ExampleClass* doSomething(ExampleClass& ec) {
  return &ec; // & unary operator - get the address of ec
}

ExampleClass obj = ExampleClass();
ExampleClass* pointer = doSomething(obj); // it will automatically get a reference to the input object