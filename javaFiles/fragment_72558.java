public List<B> getB( A a)
{
    return BtoA.get( a );
}

// i think you should only return one A here
public A getA( B b)
{
    return AtoB.get( b );
}