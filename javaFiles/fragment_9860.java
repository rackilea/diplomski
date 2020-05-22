class Catan3 extends AbstractGenerator {

    @Override
    public double generate(double low, double high)
    {
        return low + (high - low) * Math.abs(-1.5 + (rand.nextDouble() + rand.nextDouble() + rand.nextDouble())) / 1.5;
    }
}