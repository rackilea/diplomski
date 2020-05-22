RandomAccessFile rand = new RandomAccessFile("/tmp/test_log", "rw"); 
    System.out.print("file created"); //======lineA======
    while (true) {
        Thread.sleep(8000);
        System.out.print("finish sleeping");
        int i = (int) rand.length(); //=====lineB=====
        rand.seek(0); // Seek to start point of file
        for (int ct = 0; ct < i; ct++) {
            byte b = rand.readByte(); // read byte from the file
            System.out.print((char) b); // convert byte into char
        }
    }