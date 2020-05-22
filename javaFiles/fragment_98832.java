public <X extends SomeClass & SomeOtherClass>
void doReflectionMagic() {
    Map someMap = ...;
    X someData = (X) ...;
    doSomethingWithSomeMap(someMap, someData);
}