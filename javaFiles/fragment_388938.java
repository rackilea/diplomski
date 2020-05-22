public static void main(String[] args){
    B b = new B();
    A a = new A();
    a.printName(); -------- A
    b.printName(); -------- B
    b.test(); -------- test
    a.test(); -------- test
}