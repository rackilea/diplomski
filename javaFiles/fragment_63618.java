class Bar extends Boo {
    Bar() {
    }

    Bar(String s) {
        super(s);
    }

    void zoo() {
        Boo anon1 = new Boo() {                       // Line-1
            void method()
            {
                System.out.println("Inside anonymous");
            }
            @Override
            public String toString() {
                return "First anonymous subclass of Boo with value " + getString();
            }
        };
        Boo anon2 = new Boo("Some Random Value") {    // Line-2
            void method()
            {
                System.out.println("Inside anonymous");
            }
            @Override
            public String toString() {
                return "Second anonymous subclass of Boo with value " + getString();
            }
        };
        System.out.println(anon1);
        System.out.println(anon2);
    }
}