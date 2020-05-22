// The previous context ClassLoader
final ClassLoader contextCL = Thread.currentThread().getContextClassLoader();
try {
    // Set my custom ClassLoader to make my classes accessible
    Thread.currentThread().setContextClassLoader(myCustomCL);
    // Execute some code here that will be able to access to classes or resources from
    // my specific folders and/or jar files

} finally {
    // Restore the previous CL
    Thread.currentThread().setContextClassLoader(contextCL);
}