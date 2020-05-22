public static void main(String[] args) {
    new Example.OneMoreClass().method1(new Example.Foo() {
        int x;

        @Override
        public Optional<String> bar() {
            return x++ % 2 == 0 ? Optional.of("foo") : Optional.empty();
        }
    });
}