public static List<Integer> cbSeed(int n) {
    List<Integer> ol = new ArrayList<Integer>();
    ol.add(1);

    int max = (int) Math.ceil(Math.log(n) / Math.log(2));

    for (int i = 0; i < max; i++) {
        int l = 2 * ol.size() + 1;

        List<Integer> newOl = new ArrayList<Integer>(ol.size() * 2);
        for (int el : ol) {
            int e = el;
            newOl.add(e <= n ? e : 0);

            e = l - el;
            newOl.add(e <= n ? e : 0);
        }

        ol = newOl;
    }

    return ol;
}