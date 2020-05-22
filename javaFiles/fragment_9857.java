interface Generator {       
    double generate(double low, double high);
}


abstract class AbstractGenerator implements Generator {         
    protected final Random rand;

    public AbstractGenerator()
    {
        rand = new Random();
    }

    public AbstractGenerator(long seed)
    {
        rand = new Random(seed);
    }
}