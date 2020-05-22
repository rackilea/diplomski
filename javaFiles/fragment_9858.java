class Catan2 extends AbstractGenerator {

    @Override
    public double generate(double low, double high)
    {
        return low + (high - low) * Math.abs(-1 + (rand.nextDouble() + rand.nextDouble()));
    }
}