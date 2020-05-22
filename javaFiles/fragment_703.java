public static void ranCentroid() {
    Random randomPoint = new Random();
    List<Double> result = new ArrayList<>();
    for (int i = 0; i < numCen; i++) {
        int randomP = randomPoint.nextInt(Points.size());
        result.addAll(Points.get(randomP));            
    }
    System.out.println(result);
}