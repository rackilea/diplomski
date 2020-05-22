class MyClass {
    method foo() {
        print("foo");
        print("before call(MyClass.bar())");
        bar();
    }

    method bar() {
        print("bar");
        print("before call(MyClass.zot())");
        zot();
    }

    method zot() {
        print("zot");
    }

    static method main() {
        print("before call(MyClass.foo())");
        new McClass().foo();
    }
}