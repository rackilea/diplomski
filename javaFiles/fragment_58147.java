abstract class Super<Sub extends Super> {
    abstract void a_method(Sub param);
}

class Sub_A extends Super<Sub_A> {
    void a_method(Sub_A param) {

    }
}

class Sub_B extends Super<Sub_B> {
    void a_method(Sub_B param) {

    }
}