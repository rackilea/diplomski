static class TopN<T> {

    final TreeSet<T> max;
    final int size;

    TopN(int size, Comparator<T> comparator) {
        this.max = new TreeSet<>(comparator);
        this.size = size;
    }

    void add(T n) {
        max.add(n);
        if (max.size() > size)
            max.remove(max.last());
    }

    void combine(TopN<T> o) {
        for (T e : o.max)
            add(e);
    }

}

public static void main(String[] args) {
    List<Double> conditions = new ArrayList<>();
    // add elements to conditions
    TopN<Double> maxN = conditions.parallelStream()
        .map(d -> d + 5)    // some calculation
        .collect(() -> new TopN<Double>(10, (a, b) -> Double.compare(a, b)),
            TopN::add, TopN::combine);
    System.out.println(maxN.max);
}