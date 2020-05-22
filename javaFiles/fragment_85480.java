public class ImplicitNullChecks {
    class Inner {}
    void createInner(ImplicitNullChecks obj) {
        obj.new Inner();
    }

    void lambda(Object o) {
        Supplier<String> s=o::toString;
    }
}