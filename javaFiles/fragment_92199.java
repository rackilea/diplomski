public class Number 
{
    public static HashSet<Integer> pSet;
    static 
    {
        pSet = new HashSet<>();
        pSet.add(2);
    }

    public static boolean isPrime(int n) 
    {
        boolean out = true;
        if (n == 1) { return true; }
        if (pSet.contains(n)) { return true; }

        for (int i = 2; i < n; i++)
        {
            if (n % i == 0) {
                out = false;
                break;
            }
        }
        if (out) { pSet.add(n); }
        return out;
    }
}