public static void main(String[] args){
    int[] coins = new int[]{1,2};
    System.out.println("Final Count = " + count(coins, coins.length, 3, ""));
}

public static int calls = 0;

public static int count( int S[], int m, int n , String from){
    calls++;
    System.out.print("Call#" + calls + ": " + from + "; m = " + m + "; n = " + n);

    // If n is 0 then there is 1 solution (do not include any coin)
    if (n == 0)
    {
        System.out.println(" - Solution Found");
        return 1;
    }

    // If n is less than 0 then no solution exists
    if (n < 0)
    {
        System.out.println(" - No Solution Found n < 0");
        return 0;
    }

    // If there are no coins and n is greater than 0, then no solution exist
    if (m <=0 && n >= 1)
    {
        System.out.println(" - No Solution Found (other Case)");
        return 0;
    }

    System.out.println();
    // count is sum of solutions (i) including S[m-1] (ii) excluding S[m-1]
    return count( S, m - 1, n , from + "E" ) + count( S, m, n-S[m-1], from + "I" );
}