byte[] data = new byte[] {50, -106, 40, -22, 0, 0, 0, 0};
    ByteBuffer buffer = ByteBuffer.wrap(data);
    buffer.order(ByteOrder.BIG_ENDIAN);
    System.out.println(buffer.getLong()); // 3645145933890453504
    buffer = ByteBuffer.wrap(data);
    buffer.order(ByteOrder.LITTLE_ENDIAN);
    System.out.println(buffer.getLong()); // 3928528434