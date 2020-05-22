class ReadTaskHandler implements Runnable {
    SelectionKey key;

    public ReadTaskHandler(SelectionKey key) {
        this.key = key;
    }

    @Override
    public void run() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        SocketChannel channel = (SocketChannel) key.channel();

        int size = 0;
        try {
            while ((size = channel.read(buffer)) > 0) {
                System.out.println(new String(buffer.array()));
                buffer.flip();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}