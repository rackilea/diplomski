Socket socket = new Socket();
    try {
        socket.connect(new InetSocketAddress("localhost" , 9999));
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream  = socket.getOutputStream();
        outputStream.write("hello".getBytes());
        outputStream.flush();
        InputStreamReader reader = new InputStreamReader(inputStream) ;
        char [] temChar  = new char[40];
        StringBuffer buffer = new StringBuffer( );

        while (reader.read(temChar) != -1){
            buffer.append(temChar);
            System.out.println(buffer.toString() +"\n");
        }

    } catch (IOException e) {
        e.printStackTrace();
    }