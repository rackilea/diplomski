Foo[] arr = new Foo[7];
arr[0] = new Baz();
arr[1] = new Quz();
arr[2] = new Norf();
arr[3] = () -> 7; // As Foo has only one method, lambdas are allowed as well
arr[4] = new Bar() {}; // Anonymous classes are also allowed
arr[5] = new SubFoo() { public int someMethod() { return 123; } };
arr[6] = new Blablab();