interface Visitor {
    void visitChildOne(ChildOne child);
    void visitChildTwo(ChildTwo child);
    void visitChildThree(ChildThree child);
}

abstract class ParentClass {
    public abstract void accept(Visitor v);
    ...
}

class ChildClassOne extends ParentClass {
    @Override
    public void accept(Visitor v) { v.visitChildOne(this); }
}
class ChildClassTwo extends ParentClass {
    @Override
    public void accept(Visitor v) { v.visitChildTwo(this); }
}
class ChildClassThree extends ParentClass {
    @Override
    public void accept(Visitor v) { v.visitChildThree(this); }
}