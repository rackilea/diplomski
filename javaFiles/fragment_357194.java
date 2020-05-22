public class PacketInputStream extends DataInputStream {
    public DataPacket readDataPacket() throws IOException {
        String startTag = readGenStr32();
        String code = readGenStr32();

        // Do the same for name and info...
        ...

        GenValue type = readGenValue();
        GenValue count1 = readGenValue();
        GenValue count2 = readGenValue();

        // Read the endTag the same as the Strings above...
        ...

        return new DataPacket(startTag, code, name, info, type, count1, count2, endTag);
    }

    public String readGenStr32() throws IOException {
        byte[] strBuf = new byte[32];
        readFully(strBuf, 0, 32);
        return new String(strBuf).trim();
    }

    public GenValue readGenValue() throws IOException {
        byte dataType = readByte();
        byte[] value = new byte[4];
        readFully(value);
        return new GenValue(dataType, value);
    }
}