Iterator <Object> objItr = objCollection.iterator();

while(objItr.hasNext())
{
    Object o = objItr.next();
    // ...
    if ( satifiesSomeProperty ( o ) )
        objItr.remove();    // This is okay
    // ...
}