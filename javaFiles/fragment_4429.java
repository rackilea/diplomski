public class MyClass {
    private String xThing;
    public void makeThing() {
        String thing = "thing";
        xThing = thing;
        System.out.println(thing);
    }
    public void makeOtherThing() {
        String otherThing = "otherThing";
        System.out.println(otherThing);
        System.out.println(xThing);
    }
    public static void main(String args[]) {
       MyClass myObject = new MyClass();
       myObject.makeThing();
       myObject.makeOtherThing();
    }
}