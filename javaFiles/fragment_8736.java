class Summinator<TVector>
{
    final BinaryOperator<TVector> add;

    public Summinator(BinaryOperator<TVector> addFunction)
    {
        add = addFunction;
    }

    public TVector VeryLargeSum(TVector[] hugePileOfVectors)
    {
        TVector sum = hugePileOfVectors[0];
        for (int i = 1; i < hugePileOfVectors.length; i++)
        {
            sum = add.apply(sum, hugePileOfVectors[i]);
        }
        return sum;
    }
}