public class Dpair {
    double value;
    String name;

    public static Comparator<Dpair> DpairComparator
                      = new Comparator<Dpair>() {

        public int compare(Dpair dp1, Dpair dp2) {
            return Double.compare(dp1.getValue(), dp2.getValue());
        }
    };
    // getters and setters
}

public class Test {
    public static void main(String[] args) {
        Dpair[] array = new Dpair[7];
        array[0] = new Dpair(5.26d, "name1");
        array[1] = new Dpair(1.75d, "name2");
        array[2] = new Dpair(9.45d, "name3");
        array[3] = new Dpair(16.74d, "name4");
        array[4] = new Dpair(3.65d, "name5");
        array[5] = new Dpair(0.54d, "name6");
        array[6] = new Dpair(7.21d, "name7");

        // now sort your array of custom pairs on the value
        // this will bring the names with it, maintaining the relative positioning
        Arrays.sort(array, Dpair.DpairComparator);
    }
}