public void linkThem( A[] aArray, B[] bArray)
{
    for (A a : aArray)
        for (B b : bArray)
            if( theyAreLinked() )
            {
                AtoB.put( a, b );

                List<B> temp =  BtoA.get(a);
                if(temp == null)
                    temp = new ArrayList<B>();
                temp.add(b);
                BtoA.put( a,temp  ):
            }
}