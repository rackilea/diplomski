public int recur(int m) {// m = 3
    if(m == 0) {
        return 2;
    }
    int k = 0;
    System.out.println("The K before is"+ k+" m is:"+m);
    k = recur(m - 1)+1; // <-- recur(m - 1) = 4
    System.out.println("The K AFTER is"+ k+" m is:"+m);
    return k;
}