/**
 * Creates a new random number generator. This constructor sets
 * the seed of the random number generator to a value very likely
 * to be distinct from any other invocation of this constructor.
 */
public Random() { 
    this(++seedUniquifier + System.nanoTime()); 
}

private static volatile long seedUniquifier = 8682522807148012L;