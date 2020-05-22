public static void main(String[] args){
    Foo parentFoo = new Foo(1);
    System.out.println(parentFoo);  // prints "instance 1, data is now 1"
    changeReferenceFail(parentFoo); // prints "instance 2, data is now 2"
    System.out.println(parentFoo);  // prints "instance 1, data is now 1"
    mutateReference(parentFoo);     // prints "instance 1, data is now 3"
    System.out.println(parentFoo);  // prints "instance 1, data is now 3"
}
private static void changeReferenceFail(Foo myFoo) {
    myFoo = new Foo(2); // assigns a new object to the myFoo parameter variable
    System.out.println(myFoo);
}
private static void mutateReference(Foo myFoo) {
    myFoo.setData(3); // changes the reference variable internals
    System.out.println(myFoo);
}
...
class Foo {
    private static int iidSeed = 0;
    private int iid = 0;
    private int data;
    public Foo(int data) { 
        this.data = data; 
        this.iid = ++iidSeed;
    }
    public void setData(int data) { this.data = data; }
    public String toString() {
        return String.format("instance %d, data is now %d", this.iid, this.data);
    }
}