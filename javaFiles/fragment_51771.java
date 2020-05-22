abstract class EntityA<T extends AssocA> {

    // Basically, this means myA is at least an AssocA but possibly more...
    T myA;
    abstract void meet();
}

abstract class AssocA {
    int something;
    abstract void greet();
}

class AssocAConcrete extends AssocA {
    void greet() {
        System.out.println("hello");
    }
    void salute() {
        System.out.println("I am saluting.");
    }
}

class EntityAConcrete extends EntityA<AssocAConcrete> {
    void meet() {
        System.out.println("I am about to meet someone");
        myA.salute();
    }
}