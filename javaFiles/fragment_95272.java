import java.net.InetAddress;
    import java.net.NetworkInterface;
    import java.net.SocketException;
    import java.net.UnknownHostException;

    public class MACandIP{

       public static void main(String[] args){

        InetAddress ipAddress;
            byte[] macAddress;
        try {

            ipAddress = InetAddress.getLocalHost();
            System.out.println("IP address =" + ipAddress.getHostAddress());
            NetworkInterface networkInt = NetworkInterface.getByInetAddress(ipAddress);
            macAddress = networkInt.getHardwareAddress();
            StringBuilder strBld = new StringBuilder();
                    System.out.print("MAC address = ");
            for (int i = 0; i < macAddress.length; i++) {
                strBld.append(String.format("%02X%s", macAddress[i], (i < macAddress.length - 1) ? "-" : ""));
            }
            System.out.println(strBld.toString());

 //in above code assume you got MAC address as  81-7B-39-C5-A6-D4 

                if(strBld.toString().equalsIgnoreCase("81-7B-39-C5-A6-D4")){
                    // mac is correct 
                }

        } catch (UnknownHostException excep) {

            excep.printStackTrace();

        } catch (SocketException exce){
            exce.printStackTrace();
        }

       }

    }