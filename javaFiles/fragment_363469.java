class A {
    @Override protected void finalize() {
        System.out.println(this + " was finalized!");
    }

    public static void main(String[] args) {
        A a = new A();
        System.out.println("Created " + a);
        for (int i = 0; i < 1_000_000_000; i++) {
            if (i % 1_000_000 == 0)
                System.gc();
        }
        // System.out.println(a + " was still alive.");
    }
}