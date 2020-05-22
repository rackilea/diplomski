while (true){
            ByteBuffer buf = ByteBuffer.allocate(512);
            r = input.nextLine();
            buf.put(r.getBytes());
            buf.flip();
            datagramChannel.send(buf, socketAddress);
            r = null;
            messageToSend = null;
            buf.clear();
        }