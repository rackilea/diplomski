public static void main(String[] args) {
    Map<String,Double> times = new HashMap<>();
    times.put("1", 1.0);
    times.put("2", 2.0);
    times.put("null", null);
    times.put("3", 3.0);
    times.put("4", 4.0);

    Double thesum = 0.0;
    thesum = times.values().stream()
        .filter((val) -> (val != null))
        .reduce(thesum, Double::sum);

    System.out.println(thesum); // 10.0
}