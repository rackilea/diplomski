public class Proxytesting {
    private static OutputStream os;
    private static InputStream in;
    private static BufferedReader reader;
    private static int Totalsize;
    public static void main(String[] args) {
        try {         
            URL url_of_file=new URL("http://www.stockvault.net/data/s/124348.jpg");

            String hostaddress=url_of_file.getHost();
            ////////////////////for proxy server ///////////////////
            String textip="172.16.4.7";
            InetAddress host=InetAddress.getByName(textip);
            System.out.println(host);
            int port=1117;

            SocketAddress ad=new InetSocketAddress(host, 1117);
            Proxy proxy = new Proxy(Proxy.Type.SOCKS, ad);

            Socket mysocket2 = new java.net.Socket();
            mysocket2.connect(ad);

            System.out.println("Socket opened to " + hostaddress + "\n");
            String file=url_of_file.getFile();
            System.out.println(" file = "+file);
            os = mysocket2.getOutputStream();

            String headRequest = "HEAD " +url_of_file+" HTTP/1.1\r\n"
                     + "Host: "+ hostaddress +"\r\n\r\n";
            os.write(headRequest.getBytes());

            in = mysocket2.getInputStream();
            reader= new BufferedReader(new InputStreamReader(in));
            String contlength="Content-Length:";

            // 1. Read the response header from server separately beforehand.
            String response;
            Totalsize = 0;
            do{ 
                response = reader.readLine();
                if(response.indexOf("Content-Length") > -1)
                {            
                    Totalsize = Integer.parseInt(response.substring(response.indexOf(' ')+1)); 
                    response = null;
                }
            }while(response != null);  

            System.out.println(" cont_lentht ##### == "+Totalsize);

    } catch (IOException ex) {
        Logger.getLogger(Proxytesting.class.getName()).log(Level.SEVERE, null, ex);
    }