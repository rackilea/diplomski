class Foo {
    // a member class
    class InstanceMember {}
    // a member class
    static class StaticMember {}

    Foo() {
        // not a member class
        class LocalAndNotMember {}
        // not a member class
        Object anonymousAndNotMember = new Object() {};
    }
}