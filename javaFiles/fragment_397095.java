for (int i = 0; i < objList.size(); i++)
{
    Object o = objList.get(i);
    // ...
    if ( satisfiesSomeProperty(o) )
    {
       objList.remove(i);
       i--;
    }

    //caveat: only works if you don't use `i` later here
    // ...
}