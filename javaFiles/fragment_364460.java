public class Die
{
    private int seed;
    Random _randNum;

    public Die(int seed) { 
       this.seed = seed;  // actually no need to keep this value
       _randNum = new Random(seed);
    }
}