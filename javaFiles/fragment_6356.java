public static void leastToGreates(int[] temps) {
    // copying the old array temps into newTempArr
    int[] newTempArr = new int[temps.length];
    for (int i = 0; i < temps.length; i++)
        newTempArr[i] = temps[i];

    int days = 0;
    while (days < temps.length) {
        int lowest = FindLowestTempInArray(newTempArr);
        if (newTempArr[lowest] > Uninitialized)
            System.out.println("temp: " + newTempArr[lowest] + ", on day: " + lowest);
        // setting the temperature of the current lowest day to "Uninitialized"
        // (so it's not the lowest temperature anymore)
        newTempArr[lowest] = Uninitialized;
        days++;
    }
}