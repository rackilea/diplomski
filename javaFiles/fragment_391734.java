import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        final ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        final DataOutputStream dataOut = new DataOutputStream(byteOut);
        dataOut.writeInt(1);
        dataOut.writeDouble(1.2);
        dataOut.writeLong(4l);
        dataOut.close(); // or dataOut.flush()
        final byte[] bytes = byteOut.toByteArray();
        final ByteArrayInputStream byteIn = new ByteArrayInputStream(bytes);
        final DataInputStream dataIn = new DataInputStream(byteIn);
        final int integ = dataIn.readInt();
        final double doub = dataIn.readDouble();
        final long lon = dataIn.readLong();
        System.out.println(integ);
        System.out.println(doub);
        System.out.println(lon);
    }