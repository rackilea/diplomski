public static void main(String[] args) {
    final Random random = new Random();
    final int arrays = 10000;
    final int chars = 1000;
    // generate the arrays
    char[][] array = new char[arrays][chars];
    for (int i = 0; i < arrays; i++) {
        for (int j = 0; j < chars; j++) {
            array[i][j] = (char)(random.nextInt(94) + 33);
        }
    }
    // compare using Arrays equals
    long before = System.nanoTime();
    for (int i = 0; i < arrays; i++) {
        for (int j = 0; j < chars; j++) {
            equals_Arrays(array[i], array[j]);
        }
    }
    System.out.println(System.nanoTime() - before);
    // compare using String equals
    before = System.nanoTime();
    for (int i = 0; i < arrays; i++) {
        for (int j = 0; j < chars; j++) {
            equals_String(array[i], array[j]);
        }
    }
    System.out.println(System.nanoTime() - before);
}

private static boolean equals_Arrays(char[] a, char[] a2) {
    if (a == a2)
        return true;
    if (a == null || a2 == null)
        return false;

    int length = a.length;
    if (a2.length != length)
        return false;

    for (int i = 0; i < length; i++)
        if (a[i] != a2[i])
            return false;

    return true;
}

private static boolean equals_String(char[] v1, char[] v2) {
    if (v1 == v2)
        return true;
    if (v1 == null || v2 == null)
        return false;

    int length = v1.length;
    if (length == v2.length) {
        int i = 0;
        while (length-- != 0) {
            if (v1[i] != v2[i])
                return false;
            i++;
        }
        return true;
    }
    return false;
}