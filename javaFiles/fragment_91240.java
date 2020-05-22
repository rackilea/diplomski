BufferedInputStream bis = new BufferedInputStream(
                con.getInputStream());


        RandomAccessFile oSavedFile = new RandomAccessFile("D:/bbb.jpg",
                "rw");            
        oSavedFile.seek(startPos);
        int wlen = 0;
        while (wlen < length) {
            int read = bis.read(b, 0, length);
            wlen += read;
            oSavedFile.write(b, 0, read);
        }