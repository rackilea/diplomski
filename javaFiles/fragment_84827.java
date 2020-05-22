public class NaturalComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1.intValue() - o2.intValue();
    }
}