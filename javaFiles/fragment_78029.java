...
MyTest myTest;
try {
    myTest = MyTest.getInstance();
    // do stuff with an instantiated myTest
catch (UniAppException e) {
    // do stuff to handle e when myTest will be null
}
...