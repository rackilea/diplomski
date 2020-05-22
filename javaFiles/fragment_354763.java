public class TwoIntClass {

    private int i1;
    private int i2;

    public TwoIntClass(int i1, int i2) {
        this.i1 = i1;
        this.i2 = i2;   
    }

    static public void main(String...args) {

        Map<TwoIntClass, Set<Integer>> map = new HashMap<TwoIntClass, Set<Integer>>();

        Set<Integer> dataset = new HashSet<Integer>();
        dataset.add(1);
        dataset.add(2);

        TwoIntClass i1 = new TwoIntClass(5, 3);
        TwoIntClass i2 = new TwoIntClass(5, 3);

        map.put(i1, dataset);
        map.put(i2, dataset);

        System.out.println( i1.hashCode() + " = " + i2.hashCode() + " == " + i2.equals(i2) + " > map count = " + map.size() );

        TwoIntClass i3 = new TwoIntClass(5, 3);
        System.out.println("Looking for TwoIntClass(5,3)... " + map.containsKey(i3) );

    }
}