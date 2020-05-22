class Parent {
    ...
    public I newInnerClass() {
        return new NotInnerClass(this);
    }
    ...
}
class NotInnerClass implements I {
    private final Parent containingObject;

    public NotInnerClass(Parent containingObject) {
        this.containingObject = containingObject;
    }

    @Override
    public void myMethod() {
        System.out.println("parent inner class");
        containingObject.foo();
    }
}