protected boolean initThis(String pHost, int pPort) {
    list = new LinkedList<ClientProcessor>();
    host = pHost; // 192.168.1.135
    port = pPort; // 35150
    try {
        // \/ Line 57 on my code (see stack trace) \/
        server = new ServerSocket(port, 10, InetAddress.getByName(host));
    } catch (BindException bind){
        bind.printStackTrace(); //Here is the problem !!
        return false;
    } catch (UnknownHostException hoste) {
        hoste.printStackTrace();
        return false; // Change this to true if you want it to stop here
    } catch (IOException ioe) {
        ioe.printStackTrace();
        return false; // Change to true to stop here
    }
    return true;
}