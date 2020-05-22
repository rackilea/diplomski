MyClass obj = new MyClass();
LibraryClass newLibraryClass = obj.someMethodThatChangesDataReturningNewObject();
if (newLibraryClass instanceof MyClass) {
    MyClass newObj = (MyClass) newLibraryClass;
    // MyClass specific processing here
}