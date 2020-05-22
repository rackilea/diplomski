public static Set<Integer> allPalindromic(int limit) {

    Set<Integer> result = new HashSet<Integer>();

    for (int i = 0; i <= 9 && i <= limit; i++)
        result.add(i);

    boolean cont = true;
    for (int i = 1; cont; i++) {
        StringBuffer rev = new StringBuffer("" + i).reverse();
        cont = false;
        for (String d : ",0,1,2,3,4,5,6,7,8,9".split(",")) {
            int n = Integer.parseInt("" + i + d + rev);
            if (n <= limit) {
                cont = true;
                result.add(n);
            }
        }
    }

    return result;
}