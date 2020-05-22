byte[] buffer = new byte[1024];

    File f = new File("c:/users/temp.jpg");
    FileOutputStream fos = new FileOutputStream (f);

    int bytes = 0;
    boolean eof = false;

    while (!eof) {

        bytes = inputStream.read(buffer);
        int offset = bytes - 11;
        byte[] eofByte = new byte[11];
        eofByte = Arrays.copyOfRange(buffer, offset, bytes);
        String message = new String(eofByte, 0, 11);

        if(message.equals("end of file")) {

            eof = true;

        } else {

            fos.write (buffer, 0, bytes);

        }

    }
    fos.close();