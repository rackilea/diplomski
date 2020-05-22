public class MyClassLoader extends SecureClassLoader {

  @Override
  protected Class<?> findClass(String name) throws ClassNotFoundException {
     ...
     FileInputStream fis = new FileInputStream(brokenClassFile);
     BufferedInputStream bis = new BufferedInputStream(fis);
     ByteArrayOutputStream bas = new ByteArrayOutputStream((int) encryptedClassFile.length());
     byte[] wrongBytes = bas.toByteArray(); 
     byte[] goodbytes = ...     
     // add  a new byte[] and put in the appropiate missing bytes for the cafebabe and magic number
     CodeSource cs = new CodeSource(jarfile.toURI().toURL(), (CodeSigner[]) null);
     return super.defineClass(name, goodbytes, 0, bytes.length, cs);



  }

}