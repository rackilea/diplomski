int timeout = 0; //How ever long you want to set the timeout to. 
    somePageParameters = "Parameter String";
    InetSocketAddress isock = new InetSocketAddress(ip, 1000);
    Socket s = null;
    s = new Socket();
    s.connect(isock,timeout);
    OutputStream os = s.getOutputStream();
    String myString = "";
    myString = "GET "+"/"+ somePageParameters+" HTTP/1.0\n\r\n\r";
    System.err.println("Hitting with: "+myString);
    byte outbuf[] = myString.getBytes();
    os.write(outbuf);
    os.flush();