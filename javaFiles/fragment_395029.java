class MyClass1 {
    static final String IDENTIFIER = "MyClass1";
    ...
}
class MyClass2 {
    static final String IDENTIFIER = "MyClass2";
    ...
}
...
String tableName = MyClass1.IDENTIFIER;
...
switch (tableName) {
    case MyClass1.IDENTIFIER:
        return 1;
    case MyClass2.IDENTIFIER:
        return 2;
    default:
        return Integer.MAX_VALUE;
}