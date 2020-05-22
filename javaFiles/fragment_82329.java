class A {
    int x;
    A(int x) {
        System.out.printf("A() before: A.x = %d%n", this.x);  // 0
        System.out.printf("A() before: B.x = %d%n", (B) this).x);  // 0
        this.x = x;
        System.out.printf("A() after: A.x = %d%n", this.x);  // 7
        System.out.printf("A() after: B.x = %d%n", (B) this).x);  // 0
    }
}

class B extends A {
    int x = 10;
    B() {
        super(7);
        System.out.printf("B(): A.x = %d%n", super.x);  // 7
        System.out.printf("B(): A.x = %d%n", this.x);  // 10
    }
}