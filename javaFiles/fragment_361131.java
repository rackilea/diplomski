public static void stringOccurInY(String[] x, String[] y) {
    int count = 0;
    for (int i = 0; i < y.length; i++) {          
        for (int j = 0; j < x.length; j++) {
            if (y[i].contains(x[j])) {
                count++;
            }
        }
        System.out.println(y[i] + ": " + count);
        count = 0; // reset the count
    }
}