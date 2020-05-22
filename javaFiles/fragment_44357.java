URL url;
try {
    url = new URL("file:///d:/runtime-EclipseApplication/TestingProject/bin/");
    URLClassLoader ucl = new URLClassLoader(new URL[] { url });
    Class<?> clazz = ucl.loadClass("org.eclipse.testing." + className1);
    Object o = clazz.newInstance();
} catch (Exception e){
    e.printStackTrace();
}