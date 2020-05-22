static long pathWithMaxCostHash(int[][] n, int x, int y, int tokkens) {
    if (x < 0 || x >= n.length || y < 0 || y >= n[0].length)
        return -1;
    String key = x + ":" + y + ":" + tokkens;

    if (map.containsKey(key))
        return map.get(key);

    if(x==n.length-1&&y==0) {
        if (tokkens > 0 && n[x][y] > 0) {
            map.put(key,(long)n[n.length-1][0]*2);
            return 2*n[n.length-1][0];

        }
        map.put(key,(long)n[n.length-1][0]);
        return n[n.length-1][0];

    }

    //without picking double
    long val = n[x][y]
            + Math.max(pathWithMaxCostHash(n, x + 1, y, tokkens), pathWithMaxCostHash(n, x, y - 1, tokkens));
    //with picking double
    if (tokkens > 0 && n[x][y] > 0) {
        long val2 = 2 * n[x][y] + Math.max(pathWithMaxCostHash(n, x + 1, y, tokkens - 1),
                pathWithMaxCostHash(n, x, y - 1, tokkens - 1));
        val2 = Math.max(val, val2);
        map.put(key, val2);
        return val2;
    }

    map.put(key, val);
    return val;

}