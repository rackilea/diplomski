public class ListsExample {

    public static void main(String[] args) {
        List<Integer> p1 = Arrays.asList(1,2,3,4,5);
        List<Integer> p2 = Arrays.asList(1,2,3,4,5);
        List<Integer> p3 = Arrays.asList(1,2,3,4,5);
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        lists.add(p1);
        lists.add(p2);
        lists.add(p3);

        for(List<Integer> list : lists){
            System.out.println(list.get(0));
        }
    }
}