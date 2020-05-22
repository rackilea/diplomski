ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();

    // This URL for a directory will be searched *recursively*
    URL classes =
        new URL( "file:///D:/code/myCustomClassesAreUnderThisFolder/" );

    ClassLoader custom = 
        new URLClassLoader( new URL[] { classes }, systemClassLoader );

    // this class should be loaded from your directory
    Class< ? > clazz = custom.loadClass( "my.custom.class.Name" ); 
    // this class will be loaded as well, because you specified the system 
    // class loader as the parent
    Class< ? > clazzString = custom.loadClass( "java.lang.String" );