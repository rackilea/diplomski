public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        for(Iterator<Integer> it = list.iterator(); it.hasNext();it.next()){
            System.out.println(it.toString());
            list.add(4);
        }
    }
}