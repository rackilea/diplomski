abstract class Super<S extends Super> {
    abstract void aMethod(S param);
}

class SubA extends Super<SubA> {
    void aMethod(SubA param) {

    }
}

class SubB extends Super<SubB> {
    void aMethod(SubB param) {

    }
}