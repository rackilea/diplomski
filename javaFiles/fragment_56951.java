public class SortTest {

    public void sort(String[] array) {

        String insert;

        for (int next = 1; next < array.length; next++) {
            insert = array[next];

            int moveItem = next;

            while (moveItem > 0 && array[moveItem - 1].compareTo(insert) > 0) {
                array[moveItem] = array[moveItem - 1];
                moveItem--;
            }
            array[moveItem] = insert;
        }
    }

    public static void main(String[] args) {
        SortTest stringSort = new SortTest();
        String[] array = { "aaa", "ccc", "eee", "zzz", "bbb" };
        //call sorting
        stringSort.sort(array);
        //print the sorted array values
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}