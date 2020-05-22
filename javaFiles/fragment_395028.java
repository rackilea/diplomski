String tableName = "MyClass1";
...
switch (tableName) {
    case "MyClass1":
        return 1;
    case "MyClass2":
        return 2;
    default:
        return Integer.MAX_VALUE;
}