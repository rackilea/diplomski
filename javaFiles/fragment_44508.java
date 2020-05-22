public class CopyUtil {

  public void doTheCopy( List<String> resourceNames ) {

    for ( String resource : resourceNames ) { 
      InputStream is = this.getClass().getClassLoader().getResourceAsStream(resource);
      FileOutputStream fos =
        new FileOutputStream( new File(System.getProperty("user.dir"), resource));
      byte[] buffer = new byte[1024];
      int read = -1;
      while( (read = is.read(buffer)) != -1 ) {
        fos.write( buffer,0,read);
      }
      fos.flush();
      fos.close();
    }
  }
}