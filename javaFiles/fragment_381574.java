public class GenericTest{

    // use generics and auto-boxing
    // Java 1.5 or higher required
    public void generic(){
        final List<Integer> test2 = new ArrayList<Integer>();
        test2.add(343);
        final int x2 = test2.get(0);
    }

    // use neither generics nor auto-boxing,
    // this should be Java 1.4-compatible
    public void nonGeneric(){
        final List test2 = new ArrayList();
        test2.add(Integer.valueOf(343));
        final int x2 = ((Integer) test2.get(0)).intValue();
    }
}