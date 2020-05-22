public class NeverComparator implements Comparator<String> {
    private static String NEVER = "never";

    @Override
    public int compare(String o1, String o2) {
        if (NEVER.equals(o1)) {
            return NEVER.equals(o2) ? 0 : -1;
        }
        if (NEVER.equals(o2)) {
            return 1;
        }
        return o1.compareTo(o2);
    }
}