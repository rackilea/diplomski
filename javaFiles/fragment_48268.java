@Override
public Class findClass(String name) throws ClassNotFoundException {
    if(!name.equals(expectedName))
        throw new ClassNotFoundException(name);
    return defineClass(name, this.rawClassBytes, 0, this.rawClassBytes.length);
}