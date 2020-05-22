public class Binomials {
    private HashMap<Pair<BigInteger, BigInteger>, BigInteger> map = new HashMap();

    public BigInteger binomial(int n, int k) {
        return binomial(new Pair(valueOf(n), valueOf(k)));
    }

    public BigInteger binomial(Pair<BigInteger, BigInteger> x) {
        if(x.getValue().equals(ZERO) || x.getKey().equals(x.getValue())) {
            return ONE;
        }
        return map.computeIfAbsent(x, nk -> binomial(doP1(nk)).add(binomial(doP2(nk))));
    }

    private Pair<BigInteger, BigInteger> doP1(Pair<BigInteger, BigInteger> nk) {
        return new Pair(nk.getKey().subtract(ONE), nk.getValue());
    }
    private Pair<BigInteger, BigInteger> doP2(Pair<BigInteger, BigInteger> nk) {
        return new Pair(nk.getKey().subtract(ONE), nk.getValue().subtract(ONE));
    }

    public static void main(String[] args) {
        System.out.println(new Binomials().binomial(8, 4)); // 70
    }
}