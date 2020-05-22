public class SecondColumnComparator implements Comparator<double[]> {
    @Override
    public int compare(double[] row1, double[] row2) {
        return Double.compare(row1[1], row2[1]);
        // or, before Java 7:
        // return Double.valueOf(row1[1]).compareTo(Double.valueOf(row2[1]));
    }    
}