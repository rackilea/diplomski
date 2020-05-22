interface VisitorOfA {
    Object visitA(A a);
    Object visitB(B b);
}
class A {
    Object accept(VisitorOfA visitor) {
        return visitor.visitA(this);
    }
}
class B extends A {
    Object accept(VisitorOfA visitor) {
        return visitor.visitB(this);
    }
}