public class FooBar {
    static {
        Bar.TOTO.associate(Foo.TATA, Bar.TITI);
    }

    public enum Foo {
        TATA;
    }

    public enum Bar {
        TOTO,
        TITI;

        private Foo _foo;
        private Bar _bar;

        private void associate(Foo foo, Bar bar) {
            _foo = foo;
            _bar = bar;
        }

        public Foo getFoo() {
            return _foo;
        }

        public Bar getBar() {
            return _bar;
        }
    }

    public static void main(String[] args) {
        System.out.println(FooBar.Bar.TITI.getFoo());
        System.out.println(FooBar.Bar.TITI.getBar());
        System.out.println(FooBar.Bar.TOTO.getFoo());
        System.out.println(FooBar.Bar.TOTO.getBar());
    } 
}