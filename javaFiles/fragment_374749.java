public class ArrayHash {

    public static void main(String[] args) {
        String[] one = new String[]{"A", "B", "C", "D"};
        String[] two = new String[]{"D", "C", "B", "A"};
        System.out.println("One = " + one.hashCode());
        System.out.println("Two = " + two.hashCode());
        System.out.println("Method for one = "+hash(one));
        System.out.println("Method for two = "+hash(two));
    }

    private static int hash(Object[] array) {
        int ret = 0;
        for (Object c : array) {
            ret += (124567890 + c.hashCode()) * c.hashCode();
        }
        return ret;
    }
}