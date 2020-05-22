protected Class<?> findClass(final String name) throws ClassNotFoundException {
    Class result;
    try {
        result = (Class)AccessController.doPrivileged(new PrivilegedExceptionAction() {
            public Class<?> run() throws ClassNotFoundException {

// This is where the prefix is added:
                String path = PathRewritingClassLoader.this.prefix + name.replace('.', '/').concat(".class");
                Resource res = PathRewritingClassLoader.this._ucp.getResource(path, false);
                if(res != null) {
                    try {
                        return PathRewritingClassLoader.this._defineClass(name, res);
                    } catch (IOException var4) {
                        throw new ClassNotFoundException(name, var4);
                    }
                } else {
                    return null;
                }
            }
        }, this._acc);
    } catch (PrivilegedActionException var4) {
        throw (ClassNotFoundException)var4.getException();
    }

    if(result == null) {
        throw new ClassNotFoundException(name);
    } else {
        return result;
    }
}