URLClassLoader loader = URLClassLoader.newInstance(new URL[]{new File("my-jar-file.jar").toURI().toURL()});
Thread.currentThread().setContextClassLoader(loader);
Class<?> serverClass = loader.loadClass("com.foo.bar.application.MyMain");

Method main = serverClass.getMethod("main", String[].class);
String[] params = new String[]{"-flag", "value"};
main.invoke(null, (Object) params);