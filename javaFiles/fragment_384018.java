URL[] urls = new URL[] {
    /* URL to your axis jar */,
    /* other URLs you need */
};
URLClassLoader classLoader = new URLClassLoader(urls, getClass().getClassLoader());
Class<...> axisClass = classLoader.findClass(/* fully qualified name */);