class CentralServer{
 private final Configuration serverConf;

 private CentralServer(Configuration serverConf){  // inject configuration
   this.serverConf = serverConf;
 }
 public static CentralServer createCentralServer(Configuration serverConf){ // static factory perhaps
  return new CentralServer(serverConf);
 }
}