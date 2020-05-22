class Catan4 extends AbstractGenerator {

    @Override
    public double generate(double low, double high)
    {
        return low + (high - low) * Math.abs(-2 + (rand.nextDouble() + rand.nextDouble() + rand.nextDouble() + rand.nextDouble())) / 2D;
    }
}