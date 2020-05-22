public class PairTools {

    /**
     * this is how you can use wildcards in generics
     * 
     * @param pair (assume never null)
     * @return a pair containing two references to a of the given pair
     */
    public static <A> Pair<A, A> copyA(Pair<A, ?> pair) {
        return new Pair<A, A>(pair.a, pair.a);
    }

}