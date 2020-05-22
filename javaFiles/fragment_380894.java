public static Object[][] transposeSimple(Object[][] data) {
    int maxLen = 0;
    for (Object[] row : data)
        if (row.length > maxLen)
            maxLen = row.length;
    Object[][] temp = new Object[maxLen][data.length];
    for (int i = 0; i < data.length; i++)
        for (int j = 0; j < data[i].length; j++)
            temp[j][i] = data[i][j];
    return temp;
}