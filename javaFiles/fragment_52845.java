ServerSocket serverSocket = new ServerSocket(4444);
    Socket socket = serverSocket.accept();

    /* GET */
    InputStream is = socket.getInputStream();        
    BufferedOutputStream bos =  new BufferedOutputStream(new FileOutputStream("serverlog.txt"));


    int count;
    byte[] bytes = new byte[8192];

    while ((count = is.read(bytes)) > 0) {
        bos.write(bytes, 0, count);
        System.out.println("-->" + count);
    }

    System.out.println("DONE DOWNLOADING");
    bos.close();
    socket.close();


    /* SEND */
    socket = serverSocket.accept();
    BufferedInputStream fileInput = new BufferedInputStream(new FileInputStream(new File("server.txt")));
    BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());

    int count2;
    byte[] bytes2 = new byte[8192];

    while ((count2 = fileInput.read(bytes2)) > 0) {
        out.write(bytes2, 0, count2);
        System.out.println("--> " + count2);
    }
    out.close();

    /* CLOSE */
    socket.close();
    serverSocket.close();