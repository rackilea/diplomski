ClassLoader cl = Thread.currentThread().getContextClassLoader();
ClassLoader myClassLoader = new MyClassLoader(cl); // Try 'cl' before your custom class loading

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