public static void main(String[] args) {
    List<Double> list = new ArrayList<Double>();
    list.add(20.10);
    list.add(20.54);
    list.add(27.50);
    list.add(76.36);

    System.out.println("Before sort:");
    for(Double d : list) {
        System.out.println(d);
    }
    System.out.println();

    Collections.sort(list, new Comparator<Double>() {
        @Override
        public int compare(Double o1, Double o2) {
            return Double.compare(o2, o1);
        }
    });

    System.out.println("After sort:");
    for(Double d : list) {
        System.out.println(d);
    }
}