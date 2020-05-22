class SomeOtherClass {

  public <T extends MyClass> T download(Class<T> clazz, URL url) throws IOException {

    URLConnection conn = url.openConnection();

    return clazz.getConstructor(InputStream.class).newInstance(conn.getInputStream() ); // Note my MyClass constructor takes an InputStream...

  }
}