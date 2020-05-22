try (FileInputStream stream = new FileInputStream(filename)) {
        FileChannel inChannel = stream.getChannel();

        ByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        int[] result = new int[500000];

        buffer.order( ByteOrder.BIG_ENDIAN );
        IntBuffer intBuffer = buffer.asIntBuffer( );
        intBuffer.get(result);
    }