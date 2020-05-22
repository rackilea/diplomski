public class Test {

    public static void main(String[] args) {
        //one liner
        int[] array = toArray(newLinkedList(concat(range(1, 10), range(500, 1000))));

        //more readable
        Iterable<Integer> values = concat(range(1, 10), range(500, 1000));
        List<Integer> list = newLinkedList(values);
        int[] array = toArray(list);

    }

    public static List<Integer> range(int min, int max) {
        List<Integer> list = newLinkedList();
        for (int i = min; i <= max; i++) {
            list.add(i);
        }

        return list;
    }

}