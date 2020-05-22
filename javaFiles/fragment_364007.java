private static boolean e1(int m[][]) {
    if (m == null)
        return false;
    for (int i = 0, n=1; n < m.length; ++i, ++n) {
        if (m[i] != null && m[n] != null) {
            for (int j = 0; j < m[i].length && j < m[n].length; ++j) {
                if (m[i][j] < m[n][j])
                    return true;
            }
        }
    }
    return false;
}