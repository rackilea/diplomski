public static void printResource (Class<?> c) {
    String src;
    ClassLoader cl = c.getClassLoader();
    if (cl != null)
        src = cl.getResource(c.getName().replace('.', '/') + ".class").toString();
    else
        src = "[null ClassLoader]";
    System.err.println(c.getName() + " => " + src);
}