public static ArrayList<int[]> getSplits(int n, int k) {
    if (k == 1) {
        return new ArrayList<int[]>();
    }

    ArrayList<int[]> newSplits = new ArrayList<int[]>();

    for (int s = 1; s < n-(k-1)+1; s++) {
        if (k == 2) {
            newSplits.add(new int[] {s});
        } else {
            ArrayList<int[]> splits = getSplits(n-s, k-1);

            for (int[] split : splits) {
                int[] newSplit = new int[split.length + 1];
                newSplit[0] = s;
                for (int i = 0; i < split.length; i++) {
                    newSplit[i+1] = split[i] + s;
                }
                newSplits.add(newSplit);
            }
        }
    }
    return newSplits;
}