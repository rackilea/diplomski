public void buttonClicked(View view)throws IOException{
    new Thread(new Runnable() {
        @Override
        public void run() {
            int bytesRead;
    int current = 0;
    FileOutputStream fos = null;
    BufferedOutputStream bos = null;
    Socket sock = null;
    try {
        sock = new Socket(SERVER, SOCKET_PORT);
        System.out.println("Connecting...");

        // receive file
        byte [] mybytearray  = new byte [FILE_SIZE];
        InputStream is = sock.getInputStream();
        fos = new FileOutputStream(FILE_TO_RECEIVED);
        bos = new BufferedOutputStream(fos);
        bytesRead = is.read(mybytearray,0,mybytearray.length);
        current = bytesRead;

        do {
            bytesRead =
                    is.read(mybytearray, current, (mybytearray.length-current));
            if(bytesRead >= 0) current += bytesRead;
        } while(bytesRead > -1);

        bos.write(mybytearray, 0 , current);
        bos.flush();
        // System.out.println("File " + FILE_TO_RECEIVED
        //       + " downloaded (" + current + " bytes read)");
    }
    finally {
        if (fos != null) fos.close();
        if (bos != null) bos.close();
        if (sock != null) sock.close();
    }       
        }
    }).start();
}