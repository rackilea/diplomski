public void connect (final String host){
    if(host.isEmpty())
        return;

    hostname = host;
    try{
        JSch jsch=new JSch();
        String user ="yourUserName";
        String host = "yourHost";

        Session myLocalSession=jsch.getSession(user, host, 22);
        //myLocalSession=jsch.getSession(user, "192.168.1.104", 22);

        myLocalSession.setPassword("yourPassword");

        myLocalSession.setConfig("StrictHostKeyChecking", "no");

        myLocalSession.connect(5000);   // making a connection with timeout.
        myChannel = myLocalSession.openChannel("shell");

        InputStream inStream = myChannel.getInputStream();

        OutputStream outStream = myChannel.getOutputStream();
        toChannel = new PrintWriter(new OutputStreamWriter(outStream), true);

        myChannel.connect();
        readerThread(new InputStreamReader(inStream));


        Thread.sleep(100);
        sendCommand("cd "+path);
      }
    catch(JSchException e){
        String message = e.getMessage();
        if(message.contains("UnknownHostException"))
            myParser.print(">>>>> Unknow Host. Please verify hostname.");
        else if(message.contains("socket is not established"))
            myParser.print(">>>>> Can't connect to the server for the moment.");
        else if(message.contains("Auth fail"))
            myParser.print(">>>>> Please verify login and password");
        else if(message.contains("Connection refused"))
            myParser.print(">>>>> The server refused the connection");
        else
            System.out.println("*******Unknown ERROR********");

        System.out.println(e.getMessage());
        System.out.println(e + "****connect()");
      }
    catch(IOException e)
    {
        System.out.println(e);
        myParser.print(">>>>> Error when reading data streams from the server");
    }
    catch(Exception e){
        e.printStackTrace();
    }
}