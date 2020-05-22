public TCPClient() {
    try {
        //Creating socket
        Socket socket = new Socket("localhost", 6666);
        System.out.println("Enter filename");
        bffinput = new BufferedReader(new InputStreamReader(System.in));
        String filename = bffinput.readLine();
        OutputStream outputObject = socket.getOutputStream();
        // send filename over socket output stream
        outputObject.write(value.getBytes());

    } catch (Exception ex) {
        System.out.println("Unhandled exception caught");
    }
}