import java.net.InetAddress;
  import java.net.UnknownHostException;

  public class NsLookup {

    private InetAddress inet = null;

    // you need to define this extra constructor
    public NsLookup(String host){
    try{
       inet = InetAddress.getByName(host);
    }
    catch(UnknownHostException uhe){
      uhe.printStackTrace();
    }
    }
    // constructor ends here

    // Also you don't need to remove the argument received by the resolve() 
   // so that one could resolve other hostnames too.

    public void resolve(String host) {
     try {
        inet = InetAddress.getByName(host);
        System.out.println("Host name : " + inet.getHostName());
        System.out.println("IP Address: " + inet.getHostAddress());
     }
     catch (UnknownHostException e) { 
        e.printStackTrace(); 
     }
    }

 public static void main(String[] args) {
        NsLookup nsl = new NsLookup("YOUR-HOSTNAME");
        // add your rest code here
 }
}