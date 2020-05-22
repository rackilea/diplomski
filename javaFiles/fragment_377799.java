class Parent {
    String type;
    public Parent(Parent p) { this.type = p.type; }
}

class Child extends Parent {
    public Child(Parent p) { super(p); }
}