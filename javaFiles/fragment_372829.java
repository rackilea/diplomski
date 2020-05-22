import java.util.BitSet;
import java.util.Random;

/**
 * Random number generator without repeat in the given range at construction time.
 * 
 * @author martijn
 */
public class NoRepeatRandom {

    private Random random;
    private BitSet used;
    private int max;

    /**
     * Creates new instance of NoRepeatRandom, with the range <code>[0-max[</code>.
     * @param max the maximum for the range
     * @param seed the seed for the underlying {@link java.util.Random}
     */
    public NoRepeatRandom(int max, long seed)
    {
        this.max = max;
        this.used = new BitSet(max);
        this.random = new Random(seed);
    }

    /**
     * Creates new instance of NoRepeatRandom, with the range <code>[0-max[</code>.<br />
     * <code>System.currentTimeMillis()</code> is used as seed for the underlying {@link java.util.Random}
     * @param max the maximum for the range
     */
    public NoRepeatRandom(int max)
    {
        this(max, System.currentTimeMillis());
    }

    /**
     * Gives the next random number
     * @return a new random number. When finished it returns -1.
     */
    public int next()
    {
        if (isFinished())
        {
            return -1;
        }
        while (true)
        {
            int r = random.nextInt(max);
            if (!used.get(r))
            {
                used.set(r);
                return r;
            }
        }
    }

    /**
     * Tells if the random generator has finished. Which means that all number in the range
     * [0-max[ are used.
     * @return true if all numbers are used, otherwise false.
     */
    public boolean isFinished()
    {
        return max == used.cardinality();
    }

    /**
     * Sets all the numbers in the range [0-max[ to unused. Which means that all the numbers
     * can be reused.
     */
    public void reset()
    {
        used.clear();
    }

    /**
     * 
     * @return the maximum.
     */
    public int getMax()
    {
        return max;
    }
}