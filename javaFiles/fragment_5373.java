public void completeDesgloseAgrup( DesgloseBDIVO d )
{
    // will work, callee will see "something"
    d.setSomething( "something" );
}

public void completeDesgloseAgrup( DesgloseBDIVO d )
{
    // Won't work, as Java has call by value semantics. Callee won't see the new DesgloseBDIVO in callee's scope.
    d = new DesgloseBDIVO()
    d.setSomething( "something" );
}