package blammy.result;

public interface Result
{
    int calculate();
}

package blammy.result.impl;

public class AResult
implements Result;
{
    /*
     * Protected constructor to hinder naughty construction.
    */
    protected AResult(
        int x,
        int y,
        int a[],
        int b[])
    {
        ... blah;
    }

    public int calculate()
    {
        int returnValue;
        returnValue = ... blah.
        return returnValue;
    }
}
public class BResult
implements Result;
{
    /*
     * Protected constructor to hinder naughty construction.
    */
    protected BResult(
        int x,
        int y,
        boolean c)
    {
        ... blah;
    }

    public int calculate()
    {
        int returnValue;
        returnValue = ... blah.
        return returnValue;
    }
}

public static class ResultFactory
{
    public static Result createResult(
        int x,
        int y,
        int a[],
        int b[])
    {
        return new AResult(x, y, a, b);
    }

    public static Result createResult(
        int x,
        int y,
        boolean c)
    {
        return new BResult(x, y, c);
    )
}