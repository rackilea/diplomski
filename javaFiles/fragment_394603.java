interface Polite {
    void hi();
}

class Bud {
    void aMethod(Polite polite) {
        polite.hi();
    }
}

class Foo {
    void bar() {
        class Baz implements Polite {
            @Override
            public void hi() {
                System.out.println("Hi");
            }
        }
        Polite baz = new Baz();
        Bud bud = new Bud();
        bud.aMethod(baz);
    }
}