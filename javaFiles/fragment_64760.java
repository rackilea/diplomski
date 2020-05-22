public int recur(int m) {// m = 3                                | public int recur(int m) {// m = 2
    if(m == 0) {                                                 |     if(m == 0) {
        return 2;                                                |         return 2;
    }                                                            |     }
    int k = 0;                                                   |     int k = 0;
    System.out.println("The K before is"+ k+" m is:"+m);         |     System.out.println("The K before is"+ k+" m is:"+m);
    k = recur(m - 1)+1; // <-- still waiting for this to finish  |     k = recur(m - 1)+1; // <-- stop and wait for this to finish
    System.out.println("The K AFTER is"+ k+" m is:"+m);          |     System.out.println("The K AFTER is"+ k+" m is:"+m);
    return k;                                                    |     return k;
}                                                                | }