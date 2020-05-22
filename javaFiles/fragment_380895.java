public static Object[][] transposeCompact(Object[][] data) {
    int maxLen = 0;
    for (Object[] row : data)
        if (row.length > maxLen)
            maxLen = row.length;
    Object[][] temp = new Object[maxLen][];
    for (int i = 0; i < temp.length; i++) {
        for (maxLen = data.length; maxLen > 0; maxLen--)
            if (data[maxLen - 1].length > i)
                break;
        temp[i] = new Object[maxLen];
        for (int j = 0; j < maxLen; j++)
            if (i < data[j].length)
                temp[i][j] = data[j][i];
    }
    return temp;
}