File f = ...
try(RandomAccessFile ra =new RandomAccessFile(f, "r");
    FileChannel channel = ra.getChannel()){

        MappedByteBuffer fileBuffer = channel.map(MapMode.READ_ONLY, f.length()-4, 4);
        fileBuffer.load();

        ByteBuffer buf = ByteBuffer.allocate(4);
        buf.order(ByteOrder.LITTLE_ENDIAN);


        buf.put(fileBuffer);
        buf.flip();
        //will print the uncompressed size
        //getInt() reads the 4 bytes as a int
        // if the file is between 2GB and 4GB
        // then this will return a negative value
        //and you'll have to do your own converting to an unsigned int
        System.out.println(buf.getInt());
    }