while (it.hasNext()) {
    SelectionKey key = (SelectionKey )it.next();
    if (key.isReadable()) {
        System.out.println("It's readable!");

        // Added read operation
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        Charset charset = Charset.forName("UTF-8");
        buffer.clear();
        if (socketChannel.read(buffer) < 0) {
            // Client connection refused
            socketChannel.close();
            return;
        }
        buffer.flip();
        System.out.println("Value = " + charset.decode(buffer).toString());

    }
    it.remove();
}