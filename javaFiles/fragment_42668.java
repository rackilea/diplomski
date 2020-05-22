class Foo {
    private Bar myBar;
    public Foo deepCopy() {
        Foo newFoo = new Foo();
        newFoo.myBar = myBar.clone(); //or new Bar(myBar) or myBar.deepCopy or ...
        return newFoo;
    }
}