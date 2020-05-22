private static void quickSort(String[] s, int beg, int end) {
    int i = beg, j = end;

    if (end-beg >= 1) {
        String piv = s[beg];
        while (j >= i) {
            while (s[i].compareTo(piv) < 0) {
                i++;
            }
            while (s[j].compareTo(piv) > 0) {
                j--;
            }
            if (j >= i) {
                String temp = s[i];
                s[i] = s[j];
                s[j] = temp;
                i++;
                j--;
            }
        }

        for(String k : s)
            System.out.print(k);
        System.out.println();

        quickSort(s, beg, j);
        quickSort(s, i, end);

    }
}