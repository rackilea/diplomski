ClassLoader cl = Thread.currentThread().getContextClassLoader();
ClassLoader myClassLoader = ...; // You figure this out
try
{
    Thread.currentThread().setContextClassLoader(myClassLoader);

    // Do work that requires your ClassLoader to work
}
finally
{
    // Always restore the previous CCL after work is done
    Thread.currentThread().setContextClassLoader(cl);
}