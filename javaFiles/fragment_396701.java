static void plusMinus(int[] arr) {
    int pos = 0, neg = 0, zero = 0;

    for (int val : arr) {
        if (val < 0)
            neg++;
        else if (val > 0)
            pos++;
        else
            zero++;
    }

    double posDec = pos / (double) arr.length;
    double negDec = neg / (double) arr.length;
    double zeroDec = zero / (double) arr.length;
    System.out.println(posDec + "\n" + negDec + "\n" + zeroDec);
}