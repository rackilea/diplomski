Socket socket = new Socket("127.0.0.1", 4444);

    /* SEND */
    BufferedInputStream fileInput = new BufferedInputStream(new FileInputStream(new File("client.txt")));
    BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());
    int count;        
    byte[] bytes = new byte[8192];
    while ((count = fileInput.read(bytes)) > 0) {
    out.write(bytes, 0, count);
        System.out.println("-->" + count);
    }
    System.out.println("DONE UPLOADING");
    out.close();
    socket.close();

    /* GET */
    socket = new Socket("127.0.0.1", 4444);
    InputStream is = socket.getInputStream();        
    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("clientlog.txt"));

    int count2; 
    byte[] bytes2 = new byte[8192];

    while ((count2 = is.read(bytes2)) > 0) {
        bos.write(bytes2, 0, count2);
        System.out.println("-->" + count2);
    }
    bos.close();

    /* CLOSE */
    socket.close();
}