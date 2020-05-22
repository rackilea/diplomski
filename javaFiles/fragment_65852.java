public static void Sorting() {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for (WeatherLocation loc : WeatherSpots) {
        final int count = loc.CatchCount;
        if (count < min) {
            min = count;
        }
        if (count > max) {
            max = count;
        }
    }
    System.out.println("Minimum = " + min); 
    System.out.println("Maximum = " + max);
}