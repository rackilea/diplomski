import java.util.*;

class Test {

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(1);
        List<Integer> b = Arrays.asList(1,2);
        List<Integer> c = Arrays.asList(1,2,3);
        List<Integer> d = Arrays.asList(1,2,3,4);

        List<List<Integer>> test = Arrays.asList(d,b,c,a);
        Collections.sort(test, ListSizeComparator.INSTANCE);
        for (List<Integer> list : test) {
            System.out.println(list.size());
        }
    }

    enum ListSizeComparator implements Comparator<List> {
        INSTANCE;

        public int compare(List one, List other) {
            return one.size() - other.size();
        }
    }
}