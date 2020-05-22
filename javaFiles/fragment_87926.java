class Super {
    void method1() {
        System.out.println(3);
    }
}

class Sub {
    @Override
    void method1() {
        System.out.println(2 * 3);
    }

    void method2() {
        // printing 3
        super.method1();

        // printing 6
        this.method1();
    }
}