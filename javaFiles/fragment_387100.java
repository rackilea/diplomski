public class A {
    // we can initialize static members like this:
    private static Object someObject = new Object();

    // this still needs to be initialized:
    private static ArrayList<Integer> someList;

    static {
        // we can initialize it here:
        someList = new ArrayList<Integer>();
        someList.add(1);
    }
}