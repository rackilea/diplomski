class Parent {
    private int fieldA;

    Parent(int fieldA) {
        this.fieldA = fieldA;
    }

    Parent(Parent object) {
        this.fieldA = object.fieldA;
    }
}

class Child extends Parent {
    private int fieldB;

    Child(int fieldA, int fieldB) {
        super(fieldA);
        this.fieldB = fieldB;
    }
}