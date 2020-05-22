// Client REceive
DatagramSocket socket = new DatagramSocket(null);
socket.setReuseAddress(true);
socket.bind(new InetSocketAddress("127.0.0.1", 4002));


// ClientSEnd
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
socket = new DatagramSocket();  
socket.setReuseAddress(true);