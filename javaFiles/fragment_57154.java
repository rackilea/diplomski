interface Visitor {
    void visitGiraffe(Giraffe g);
    void visitZebra(Zebra z);
}
abstract class Animal {
    public abstract void accept(Visitor v);
}
class Giraffe extends Animal {
    public void accept(Visitor v) {
        v.visitGiraffe(this);
    }
}
class Zebra extends Animal {
    public void accept(Visitor v) {
        v.visitZebra(this);
    }
}