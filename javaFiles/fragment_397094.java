for (int i = objList.size() - 1; i >= 0; i--)
{
    Object o = objList.get(i);
    // ...
    if ( satisfiesSomeProperty(o) )
       objList.remove(i);
    // ...
}