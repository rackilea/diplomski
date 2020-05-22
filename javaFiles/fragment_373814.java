public InstrumentingClassLoader() {
    super(InstrumentingClassLoader.class.getClassLoader());
    this.classLoader = InstrumentingClassLoader.class.getClassLoader();
}

@Override
public Class<?> loadClass(String name) throws ClassNotFoundException {
    [... as above ...]
    result = classLoader.loadClass(name);
    return result;
}