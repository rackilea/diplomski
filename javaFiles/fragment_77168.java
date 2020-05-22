public class TcpClient {

    private String serverIp = "";

    public TcpClient(String serverIp){

        this.serverIp = serverIp;

    }

}


...

TcpClient client = new TcpClient(newIpAddress);