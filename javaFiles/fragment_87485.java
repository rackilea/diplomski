/**
 * Returns a predicate that evaluates to true with a probability
 * of toChoose/total.
 */
static Predicate<Object> randomPredicate(int total, int toChoose) {
    Random random = new Random();
    return obj -> random.nextInt(total) < toChoose;
}