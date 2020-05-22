ByteBuffer extraData = ByteBuffer.wrap(zipEntry.getExtra());
extraData.order(ByteOrder.LITTLE_ENDIAN);

while (extraData.hasRemaining()) {
    int id = extraData.getShort() & 0xffff;
    int length = extraData.getShort() & 0xffff;

    if (id == 0x756e) {
        int crc32 = extraData.getInt();
        short permissions = extraData.getShort();
        int linkLengthOrDeviceNumbers = extraData.getInt();
        int userID = extraData.getChar();
        int groupID = extraData.getChar();

        ByteBuffer linkDestBuffer = extraData.slice().limit(length - 14);
        String linkDestination =
            StandardCharsets.UTF_8.decode(linkDestBuffer).toString();

        // ...
    } else {
        extraData.position(extraData.position() + length);
    }
}