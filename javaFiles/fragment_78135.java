public class Binom {

    private long[][] mapped;

    public Binom(){
        mapped = new long[52][52];
    }

    public long binom(int n, int r) {
        if (r == 0)
            return 1;
        if (r == 1)
            return n;

        if(r > n-r)
            r = n-r;
        long toReturn = 1;
        for (int i = 1, m = n; i <= r; i++, m--){
            toReturn = toReturn*m/i;
        }
        return toReturn;
    }

    public long[][] getMapped() {
        return mapped;
    }
}