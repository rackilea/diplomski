static int count(int[] t) {
    if(t.length == 1)
        return t[0];
    else if (t.length > 1) {
        int[] tt = new int[t.length - 1];
        for (int i = 0; i < t.length - 1; i++)
            tt[i] += t[i] + t[i + 1];
        return count(tt);
    }
    return 0;
}