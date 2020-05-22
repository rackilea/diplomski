class ClassA
{
    private static final ... method1_impl = higherOrder(params);
    public void method1 (...)
    {
        method1_impl.apply (...);
    }
}