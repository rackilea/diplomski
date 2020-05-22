public class VPNConnectivityProfileValueSource implements ProfileValueSource {

  private String vpnEnabled = "true";
  public VPNConnectivityProfileValueSource () {
     // no spring context is available here
     ClassPathResource resource = new ClassPathResource("vpn-config.properties");

     if (resource.exists()) {
          // read the VPN address, 
          //   
          //this.testProps = PropertiesLoaderUtils.loadProperties(resource);
          // invoke your utility, check the connectivity, etc. 
          this.vpnEnabled = ...
     }

}

  @Override
  public String get(String key) {
    // this is important method, 
    if(key.equals("vpn.enabled") {
       return this.vpnEnabled;  
    } 
    else return System.getProperty(key);
  }
}