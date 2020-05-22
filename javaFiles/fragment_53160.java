class D implements Comparable<D> {
    double key;
    double value;

    @Override
    public int compareTo(D other) {
        return Double.compare(key, other.key);
    }
}

public class Test {
    public static void main(String[] args) {
        double[] vectorUsedForSorting = new double[] { 5.8,6.2,1.5,5.4 };
        double[] vectorToBeSorted = new double[] {1.1,1.2,1.3,1.4};

        D[] array = new D[vectorUsedForSorting.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = new D();
            array[i].key = vectorUsedForSorting[i];
            array[i].value = vectorToBeSorted[i];
        }

        Arrays.sort(array);

        for (int i = 0; i < array.length; i++) {
            vectorToBeSorted[i] = array[i].value;
        }

        System.out.println(Arrays.toString(vectorToBeSorted));

    }
}