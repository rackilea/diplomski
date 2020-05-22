public class MyComparator implements Comparator<Long> {
    @Override
    public int compare(Long long1, Long long2) {
        return long1.compareTo(long2);
    }
}