class ClassB {
    // ... code omitted for brevity

    ClassB(int[] a) {
        seta(a);
    }

    int[] geta() {
        int[] copy = new int[a.length];
        System.arraycopy(a, 0, copy, 0, a.length);
        return copy;
    }

    void seta(int a[]) {
        this.a = new int[a.length];
        System.arraycopy(a, 0, this.a, 0, a.length);
    }
}