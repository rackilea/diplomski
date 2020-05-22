try
{
    try
    {
        throw new NullPointerException();
    }
    catch (Exception x)
    {
        System.out.println("caught Exception" + x.getMessage());
        x.printStackTrace();
        throw x; // keep original behaviour
    }
    finally
    {
        System.out.println("finally is executing");
        throw new java.io.IOException();
    }
}
catch (java.io.IOException x)
{
    System.out.println("caught IOException");
}