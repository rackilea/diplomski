class MyClass {
    method foo() {
        print("foo");
        bar();
    }

    method bar() {
        print("bar");
        zot();
    }

    method zot() {
        print("zot");
    }

    static method main() {
        new McClass().foo();
    }
}