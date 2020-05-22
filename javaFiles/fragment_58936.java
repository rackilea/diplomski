static int migratoryBirds(int[] arr) {
    int max = 1;
    int[] freq = new int[6];

    for (int val : arr)
        freq[val]++;

    for (int i = 2; i < freq.length; i++)
        max = freq[i] > freq[max] ? i : max;

    return max;
}