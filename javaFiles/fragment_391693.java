public class PivotComparator implements Comparator<Integer> {

    private int pivot;

    public PivotComparator(int pivot) {
        super();
        this.pivot = pivot;
    }

    @Override
    public int compare(Integer a, Integer b) {
        return Math.abs(a - pivot) - Math.abs(b - pivot);
    }

    public static void main(String[] args) {

        Integer[] toSort = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        Comparator<Integer> comp = new PivotComparator(5);

        Arrays.sort(toSort, comp);
        for (Integer i : toSort) {
            System.out.println(i);
        }

    }

}