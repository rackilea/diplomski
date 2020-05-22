class Parent {
    String type;
    public copyInstance(Parent p) { this.type = p.type; }
}

class Child extends Parent {
    static Child newInstance(Parent p) { Child c = new Child(); c.copyInstance(p); return c; }
 }