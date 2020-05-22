interface MyInterface {
    ...
}
try {
    URL classUrl;
    classUrl = new URL(<path to the dir containg the .class file>); 

    URL[] classUrls = { classUrl };
    URLClassLoader ucl = new URLClassLoader(classUrls);

    Class clazz = ucl.loadClass(<your class name>); 
    if (MyInterface.class.isInstance(clazz.newInstance())){
        ...
    }
}
catch (Exception e){ System.out.println(e);}