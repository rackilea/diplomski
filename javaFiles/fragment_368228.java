public static int[] answer(int[] l, int t) {
    int[] rets = {-1, -1};
    int sum=0;
    for (int i=0; i<l.length; i++) {
        sum=0;
        for (int j=i; j<l.length; j++) {
            sum+=l[j];
            if (sum > t) break;
            if (sum == t) {
                rets[0] = i;
                rets[1] = j;
                return rets;
            }    
        }
    }
    return rets;
}