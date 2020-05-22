public static boolean openURI(String uri)
{
    PrintStream prevErr = System.err;
    try
    {
        System.setErr(NullPrintStream.instance);
    }
    catch(SecurityException ignored)
    {
        return Gdx.net.openURI(uri);
    }

    try
    {

        return Gdx.net.openURI(uri);
    }
    finally
    {
        System.setErr(prevErr);
    }
}