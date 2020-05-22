public byte[] readBytes(InputStream inputStream, int length)
        throws IOException {
    byte[] data = new byte[length];
    int len = inputStream.read(data);
    if (len != length) {
        throw new IOException("Read the end of stream.");
    }
    return data;
}


//Get Header data
byte[] headerData = readBytes(inputStream, 9);

// I think header data need to parse again, its structure should look like the following format:
// | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
// |  Version  | Type  | other values  |
// You can parse them to use headerData


// #######################################
// write bytes
public class ByteWriter {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    public void writeBytes(byte[] data) {
        try {
            outputStream.write(data);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public byte[] getBytes() {
        return outputStream.toByteArray();
    }
}