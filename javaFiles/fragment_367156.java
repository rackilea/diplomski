class YourClassLoader extends URLClassLoader {
    ...
    public YourClassLoader() {
       this(YourClassLoader.class.getClassLoader());
       ...
       this.addURL(jarfile.toURI().toURL());
       ...
    }
    ...
}

Class<?> yourClass = yourClassLoader.loadClass(className);
YourClassInterface yourClassInterface = null;
yourClassInterface = (YourClassInterface ) yourClass.newInstance();