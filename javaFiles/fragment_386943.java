public static void main(String[] args) {
    Foo f = new Foo() {
        @Override
        public void bar(Object x) {
            System.out.println(x);
        }
    };

    f.bar("baz");
}