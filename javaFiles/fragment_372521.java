public static void main(String[] args) {
    String w1 = args[0];
    String w2 = args[1];

    int numberOfCrosses = 0;

    for (int i=0; i < w1.length(); i++) {
        for (int j=0; j < w2.length(); j++) {
            if (w1.charAt(i) == w2.charAt(j)) {
                numberOfCrosses++;
                printCross(w1, i, w2, j);
            }
        }
    }

    if (numberOfCrosses == 0) {
        System.out.println("Words do not cross");
    }
}