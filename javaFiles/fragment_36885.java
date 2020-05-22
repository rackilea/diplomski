String[] args = new String[0]; //Add arguments for main call.

//Add whatever classpath elements you need.
String[] classpath = {"file:///example/path/to/studentProjectJarFile.jar", 
                      "file:///example/path/to/studentProjectDir/"};

//Create classloader.
ClassLoader cl = 
            new URLClassLoader(classpath);

Class<?> mainClazz;
Method mainMethod;

//Find Class.
mainClazz = cl.loadClass("com.example.MyClass"); 
//Find the target method.
mainMethod = mainClazz.getMethod("main", String[].class); 
//Invoke method.
mainMethod.invoke(null, (Object) args);