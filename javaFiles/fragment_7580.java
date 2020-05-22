class Distribution<T> {
    private double[] cummulativeWeight;
    private T[] item;
    private double totalWeight;

    Distribution(Map<T, Double> probabilityMap) {
        int i = 0;

        cummulativeWeight = new double[probabilityMap.size()];
        item = (T[]) new Object[probabilityMap.size()];

        for (Map.Entry<T, Double> entry : probabilityMap.entrySet()) {
            item[i] = entry.getKey();
            totalWeight += entry.getValue();
            cummulativeWeight[i] = totalWeight;
            i++;
        }
    }

    T randomItem() {
        double weight = Math.random() * totalWeight;
        int index = Arrays.binarySearch(cummulativeWeight, weight);
        if (index < 0) {
            index = -index - 1;
        }
        return item[index];
    }

    Set<T> randomSubset(int size) {
        Set<T> set = new HashSet<>();
        while(set.size() < size) {
            set.add(randomItem());
        }
        return set;
    }
}



public class Test {

    public static void main(String[] args) {
        int max = 1_000_000;
        HashMap<Integer, Double> probabilities = new HashMap<>();
        for (int i = 0; i < max; i++) {
            probabilities.put(i, (double) i);
        }

        Distribution<Integer> d = new Distribution<>(probabilities);
        Set<Integer> set = d.randomSubset(max / 2);
        //System.out.println(set);
    }
}