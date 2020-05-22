public static void ranCentroid() {
    Random randomPoint = new Random();
    List<List<Double>> result = new ArrayList<>();
    for (int i = 0; i < numCen; i++) {
        int randomP = randomPoint.nextInt(Points.size());
        result.add(Points.get(randomP));            
    }
    System.out.println(result);
}