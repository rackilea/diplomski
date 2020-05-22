public class A
{
    public /*@ pure @*/ int doA(int x)
    { ... }

    //@ requires ...
    //@ ensures doA(x) == doA(y)
    public int doB(int x, int y)
    { ... }
}