InputStream in = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] read = new byte[1024];
        int len;
        while((len = in.read(read)) > -1) {
            baos.write(read, 0, len);
        }
        // this is the final byte array which contains the data
        // read from Socket
        byte[] bytes = baos.toByteArray();