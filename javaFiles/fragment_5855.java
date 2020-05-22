{
        Socket sock = servsock.accept();
        byte[] mybytearray = new byte[4096];
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(myFile));
        OutputStream os = sock.getOutputStream();
        int amt = bis.read(mybytearray, 0, 4096);
        while (amt>0) {
            os.write(mybytearray, 0, amt);
            amt = bis.read(mybytearray, 0, 4096);
        }
        os.flush();
        sock.close();
    }