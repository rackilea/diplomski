for (int i = 0, c = counts.length; i < c; ++i) {
    if (counts[i] > 0) {
        if (counts[i] > 1) {
            System.out.println(value + " occurs " + counts[i]+ " times");
        } else {
            System.out.println(value + " occurs " + counts[i]+ " time");
        }
    }
}