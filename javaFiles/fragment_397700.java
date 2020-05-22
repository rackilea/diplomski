public class B {
    private static HashMap<Integer, String> hm = new HashMap<Integer, String>();

    static {
        A.setHm(hm);
    }
}