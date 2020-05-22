public static int findMostCommonElement(int[] list) {
    int max = 0;
    for (int i : list)
        if (i > max)
            max = i;
    int[] newArr = new int[max];
    for (int i = 0; i < max; i++)
        newArr[i] = 0;
    for (int i = 0; i < max; i++)
        newArr[list[i]] += 1;
    int mostCommon = 0;
    int mostCommonMax = 0;
    for (int i = 0; i < max; i++)
        if (newArr[i] > mostCommonMax) {
            mostCommonMax = newArr[i];
            mostCommon = i;
        }
    return mostCommon;
}