Class<?> clazz = Class.forName("[[Lcom.foo.Test;", true, new ClassLoader() {
    @Override
    public Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        System.out.println("Loading " + name);
        return super.loadClass(name, resolve);
    }
});
System.out.println(clazz);