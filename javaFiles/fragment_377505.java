// Here is the existing IP address in my local network, or you will get the exception
try (Socket socket = new Socket("192.168.0.1", 80)) {
    System.out.println(socket.getLocalAddress().getHostAddress());
} catch (UnknownHostException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}