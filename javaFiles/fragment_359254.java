public static int driveSoln(int n, Integer[] covers){
    return helper(covers, new boolean[n], 0, 0);
}

private static int helper(Integer[] covers, boolean[] marked, int idx, int used){
    boolean done;
    for(boolean d: marked) done = done && d;
    if(done) return used;

    if(idx >= covers.length) return -1;

    boolean [] markCopy = marked.clone();
    covers[i].markOff(marked);
    int dontUse = helper(covers, markCopy, idx + 1, used);
    int use = helper(covers, marked, idx + 1, used + 1);
    return Math.min(use, dontUse);
}