class A {
    int i = 0; // default value

    A() { 
        A::i = 4;  // originally in initialization statement
        print();
    }

    void print () {
        System.out.println("A");
    }
}

class B extends A {
    int i = 0;              // Remember this shadows A::i

    public B() {
        super();
        B::i = 2;
    }

    void print () {
        System.out.println(i);
    }
}