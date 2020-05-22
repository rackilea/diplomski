public class TestLevelSorting {
public static void main(String[] args) {

    List<double[]> levelList = new ArrayList<double[]>();

    double[] items1 = {1.0, 2.01, 2.1};
    double[] items2 = {2.0, 5.0, 2.2};
    double[] items3 = {1.0, 5.0, 1.0};

    levelList.add(items1);
    levelList.add(items2);
    levelList.add(items3);

    Collections.sort(levelList, Linearize.RATIO_ORDER);

    for(double[] item : levelList){
        System.out.println(Arrays.toString(item));
    }
}
}

class Linearize {
static final Comparator<double[]> RATIO_ORDER = new Comparator<double[]>() {
    @Override
    public int compare(double[] d1, double[] d2) {
        // Sort the ratios based on the fraction column 2
        return Double.compare(d1[2], d2[2]);
    }
};
}