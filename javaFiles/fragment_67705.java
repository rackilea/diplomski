class HelloWorldClassLoader extends ClassLoader {

  @Override
  public Class loadClass(String name) throws ClassNotFoundException {
    if (!"MyClass".equals(name)) return super.loadClass(name);
    byte[]  bb=ByteStreams.toByteArray(
                 getResourceAsStream(name.replace('.','/')+".class"));
    return defineClass(name,bb,0,bb.length);
  }
}