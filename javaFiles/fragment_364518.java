class CustomClassLoader extends ClassLoader {
     public CustomClassLoader(URLClassLoader parent, ...your data...) {
         super(parent);
         ...
     }
}

CustomClassLoader customClassLoader = new CustomClassLoader(jarLoader, ...);