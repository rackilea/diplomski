public static void combine(List<List<String>> data, int[] pos, int n, List<String> res) {
    if (n == pos.length) {
        StringBuilder b = new StringBuilder();
        for (int i = 0 ; i != pos.length ; i++) {
            b.append(data.get(i).get(pos[i]));
        }
        res.add(b.toString());
    } else {
        for (pos[n] = 0 ; pos[n] != data.get(n).size() ; pos[n]++) {
            combine(data, pos, n+1, res);
        }
    }
}