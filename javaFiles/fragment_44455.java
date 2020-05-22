class MyBuilder1 {
    public MyBuilder1(A) { ... }
    public MyBuilder1(B) { ... }

    public MyBuilder2 build(C) { ... }
    public MyBuilder2 build(D) { ... }
    public MyBuilder2 build(E) { ... }

    class MyBuilder2 {
        public MyBuilder2(C) { ... }
        public MyBuilder2(D) { ... }
        public MyBuilder2(E) { ... }

        public SomeClass build(F) { ... }
        public SomeClass build(G) { ... }
    }
}

SomeClass x = new MyBuilder1(B).build(D).build(F);