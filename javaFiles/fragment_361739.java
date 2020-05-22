static String GetStringFromUuid (java.util.UUID myUuid){
    byte[] bytes = new byte[16];
    // convert uuid to byte array
    ByteBuffer bb = ByteBuffer.wrap(bytes);
    bb.putLong(myUuid.getMostSignificantBits());
    bb.putLong(myUuid.getLeastSignificantBits());
    // reorder
    return String.format("%02x%02x%02x%02x-%02x%02x-%02x%02x-%02x%02x-%02x%02x%02x%02x%02x%02x",
        bytes[4],bytes[5],bytes[6],bytes[7],
        bytes[2],bytes[3],bytes[0],bytes[1],
        bytes[15],bytes[14],bytes[13],bytes[12],
        bytes[11],bytes[10],bytes[9],bytes[8]);
}