private static URL getManifestUrlForClass(Class<?> cl)
    throws MalformedURLException
{
    URL url=cl.getResource(cl.getSimpleName() + ".class");
    String s=url.toString();
    return new URL(s.substring(0, s.length() - (cl.getName() + ".class").length()) + "META-INF/MANIFEST.MF");