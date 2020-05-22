public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    //get next 2n numbers i.e n key value pairs using getValues() function into a hashmap
    HashMap<Integer, Integer> map = getValues(n, sc);
    ...
}

static HashMap<Integer, Integer> getValues(int n, Scanner sc) {
    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    for (int i = 1; i <= n; i++) {
        int k = sc.nextInt();
        int v = sc.nextInt();
        hm.put(k, v);
    }
    return hm;
}