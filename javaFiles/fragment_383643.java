class A {
    public void m() {
        final int c = 42;

        class B implements I {
            public void r() {
                System.out.println(c);
            }
        }
    }
}