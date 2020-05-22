doSomethingMethod();  // Works, but does nothing
doSomethingMethod("John"); // Does something with John
doSomethingMethod("John", "Steve"); // Does something with John and Steve
String[] names = new String[100];
for (int i=0; i < 100; i++) {
    // add names into names
}
doSomethingMethod(names); // Does something with 100 names.