static int sockMerchant(int n, int[] ar) {
    ArrayList<Integer> colors = new ArrayList<Integer>(10);
    int pairs = 0;

    for (int i = 0; i < n; i++) {
       if (!colors.contains(ar[i])) {
            colors.add(ar[i]);
        } else {
            pairs++;
            colors.remove(color.indexOf(ar[i]));
        }
    }

    System.out.println(pairs);
    return pairs;
}