private void permutation(String prefix, String str) {
    int n = str.length();
    myList.add(prefix);
    if(n > 0) {
        for (int i = 0; i < n; i++)
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));

    }