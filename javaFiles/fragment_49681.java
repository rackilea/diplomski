//2 different classloaders 
    ClassLoader cl1 = new ParentLastURLClassLoader(urls);
    ClassLoader cl2 = new ParentLastURLClassLoader(urls);
    //LegacySingleton with value = true in Classloader space of cl1
    cl1.loadClass("LegacySingleton").getMethod("setup", boolean.class).invoke(null, true);
    //LegacySingleton with value = false in Classloader space of cl1
    cl2.loadClass("LegacySingleton").getMethod("setup", boolean.class).invoke(null, false);