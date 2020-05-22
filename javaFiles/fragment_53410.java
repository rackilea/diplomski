File jar1 = new File("/path/to/v1.jar");
File jar2 = new File("/path/to/v2.jar");

URLClassLoader v1Loader = URLClassLoader.newInstance(new URL[] { jar1.toURI().toURL() });
URLClassLoader v2Loader = URLClassLoader.newInstance(new URL[] { jar2.toURI().toURL() });

Class<?> engineClass1 = v1Loader.loadClass("org.example.Engine");
Class<?> engineClass2 = v2Loader.loadClass("org.example.Engine");

Method runMethod1 = engineClass1.getMethod("run");
Method runMethod2 = engineClass2.getMethod("run");

Object engine1 = engineClass1.newInstance();
Object engine2 = engineClass2.newInstance();

String result1 = (String) runMethod1.invoke(engine1);
String result2 = (String) runMethod2.invoke(engine2);