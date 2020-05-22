for( Object o : objCollection )
{
    // ...
    if ( satisfiesSomeProperty ( o ) )
       objList.remove(o);    // This is an error!!
    // ...
}