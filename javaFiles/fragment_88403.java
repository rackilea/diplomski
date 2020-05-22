public class ApiFactory {
  public static Api createApi() {
    if(isTargetPlatform1()) 
      return new com.example.foo.app.Api();
    else
      return new net.example.foo.app.Api();
  }

  private boolean isTargetPlatform1() {
    // determine the current platform, e.g. by reading a configuration file
  }
}