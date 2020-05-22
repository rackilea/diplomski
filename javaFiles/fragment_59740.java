class Arithmetic
{
    static <T> GeneralNumber<T> computeSomething(
        GeneralNumber<T> a, GeneralNumber<T> b)
    {
        GeneralNumber<T> c = a.add(b);             // c      = a + b
        GeneralNumber<T> d = c.additiveInverse();  // d      = -c
        GeneralNumber<T> result = c.multiply(d);   // result = c * d
        return result;
    }
}

interface GeneralNumber<T>
{
    T get();

    GeneralNumber<T> add(GeneralNumber<T> a);
    GeneralNumber<T> additiveInverse();
    GeneralNumber<T> additiveNeutral();

    GeneralNumber<T> multiply(GeneralNumber<T> a);
    GeneralNumber<T> multiplicativeInverse();
    GeneralNumber<T> multiplicativeNeutral();
}

class GeneralDoubleNumber implements GeneralNumber<Double>
{
    static GeneralDoubleNumber of(double d)
    {
        return new GeneralDoubleNumber(d);
    }

    private final double value;
    public GeneralDoubleNumber(double d)
    {
        this.value = d;
    }

    @Override
    public Double get()
    {
        return value;
    }

    @Override
    public GeneralNumber<Double> add(GeneralNumber<Double> a)
    {
        return of(get() + a.get());
    }

    @Override
    public GeneralNumber<Double> additiveInverse()
    {
        return of(-get());
    }

    @Override
    public GeneralNumber<Double> additiveNeutral()
    {
        return of(0.0);
    }

    @Override
    public GeneralNumber<Double> multiply(GeneralNumber<Double> a)
    {
        return of(get() * a.get());
    }

    @Override
    public GeneralNumber<Double> multiplicativeInverse()
    {
        return of(1.0 / get());
    }

    @Override
    public GeneralNumber<Double> multiplicativeNeutral()
    {
        return of(1.0);
    }

}