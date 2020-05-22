public class MyClass {
    public static String xThing;
    private static void makeThing() {
        String thing = "thing";
        xThing = thing;
        System.out.println(thing);
    }
    private static void makeOtherThing() {
        String otherThing = "otherThing";
        System.out.println(otherThing);
        System.out.println(xThing);
    }
    public static void main(String args[]) {
        makeThing();
        makeOtherThing();
    }
}