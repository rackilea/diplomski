class MyClass {
    method foo() {
        print("before execution(MyClass.foo())");
        print("foo");
        bar();
    }

    method bar() {
        print("before execution(MyClass.bar())");
        print("bar");
        zot();
    }

    method zot() {
        print("before execution(MyClass.zot())");
        print("zot");
    }

    static method main() {
        print("before execution(MyClass.main())");
        new McClass().foo();
    }
}