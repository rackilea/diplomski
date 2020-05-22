if(key.isReadable()) {
    // Get the channel and read in the data
    SocketChannel keyChannel = (SocketChannel)key.channel();
    ByteBuffer buffer = buffers.get(keyChannel);
    int length = 0;
    try {
        length = keyChannel.read(buffer);
    } catch ( IOException ioe) {
        key.cancel();
        closeChannel(keyChannel);
    }
    if (length > 0) {
        buffer.flip();
        // Gather the entire message before processing
        if (buffer.remaining() > 0) {
            byte[] data = new byte[buffer.remaining()];
            buffer.get(data);
            buffer.rewind();
            int index = 0;
            int i = 0;
            // Check for the beginning of a packet
            //[ = 91
            //] = 93
            //{ = 123
            //} = 125
            if (data[0] == 91 || data[0] == 123) {
                // The string we are looking for
                byte targetByte = (byte) (data[0] + 2);
                for (byte b : data) {
                    i += 1;
                    if (b == targetByte) {
                        index = i;
                        break;
                    }
                }
                if (index > 0) {
                    data = new byte[index];
                    buffer.get(data, 0, index);
                    fireReceiveEvent(keyChannel, data);
                }
            } else {
                for (byte b : data) {
                    i += 1;
                    if (b == 91 || b == 123) {
                        index = i;
                        break;
                    }
                }
                if (index > 0) {
                    data = new byte[index];
                    buffer.get(data, 0, index); // Drain the data that we don't want
                }
            }
        }
        buffer.compact();
    } else if (length < 0) {
        key.cancel();
        closeChannel(keyChannel);
    }
}