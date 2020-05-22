public class AFactory {
    private final List<A> aList = new ArrayList<>(a);

    public A buildA() {
         A a = new A();
         aList.add(a);
         return a;
    }
}