public static void main(String args[]) {
    int lung = 1, lungmax = 0;
    int indice = 0;
    int[] values = {1, 2, 2, 3, 3, 3, 5, 5, 5, 5, 6};
    for (int k = 1; k < values.length; k++) {

        if (values[k - 1] == values[k]) {
            lung++;
            if (lung > lungmax) {
                lungmax = lung;
                indice = values[k];
            }
        } else {
            lung = 1;
        }
    }
    System.out.println("the length of the longest subsequence is: " + indice + "/" + lungmax);
}