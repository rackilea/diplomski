class Summinator<TVector>
{
    final BinaryOperator<TVector> add;

    public Summinator(Class<TVector> cVector)
    {
        MethodHandles.Lookup l = MethodHandles.lookup();
        MethodType addSignature = MethodType.methodType(cVector, cVector, cVector);
        try
        {
            MethodHandle addMethod = l.findStatic(cVector, "add", addSignature);
            add = (BinaryOperator<TVector>)LambdaMetafactory.metafactory(l, "apply",
                  MethodType.methodType(BinaryOperator.class),
                  addSignature.erase(), addMethod, addSignature)
                .getTarget().invokeExact();
        }
        catch(RuntimeException|Error t)
        {
            throw t;
        }
        catch(Throwable t) {
            throw new IllegalArgumentException("not an appropriate type "+cVector, t);
        }
    }

    public TVector VeryLargeSum(TVector[] hugePileOfVectors)
    { // if hugePileOfVectors is truly huge, this can be changed to parallel execution
        return Arrays.stream(hugePileOfVectors).reduce(add)
            .orElseThrow(() -> new IllegalArgumentException("empty array"));
    }
}