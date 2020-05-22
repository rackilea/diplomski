public static void main(String[] args) throws FileNotFoundException, IOException {

    byte[] data = new byte[] {1, 0, 0, 0, 0, 0, 0, 102, 89, 111, 117, 114, 32, 119, 111, 114, 100, 115, 32, 97, 114, 101, 32, 104, 101, 114, 101, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 32, 33, 33, 10, 89, 111, 117, 114, 32, 119, 111, 114, 100, 115, 32, 97, 114, 101, 32, 104, 101, 114, 101, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 32, 33, 33, 10, 89, 111, 117, 114, 32, 119, 111, 114, 100, 115, 32, 97, 114, 101, 32, 104, 101, 114, 101, 46, 46, 46, 46, 46, 46, 46, 46, 46,46, 46, 32, 33, 33, 10, 1, 0, 0, 0, 0, 0, 0, 21, 105, 110, 112, 117, 116, 32, 105, 110, 32, 87, 111, 114, 100, 115, 32, 58, 32, 32, 84, 101, 110, 1, 0, 0, 0, 0, 0, 0, 1, 10, 1, 0, 0, 0, 0, 0, 0, 19, 67, 79, 77, 69, 32, 79, 78, 32, 76, 73, 75, 69, 32, 73, 84, 32, 33, 33, 10};
    InputStream is = new ByteArrayInputStream(data); //I just created this for testing

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    byte[] header = new byte[8];
    while(true){
        if(!readFully(is, header, 8)) break;
        int contentSize = ((header[4] & 0xFF) << 24) | ((header[5] & 0xFF) << 16)
                | ((header[6] & 0xFF) << 8) | (header[7] & 0xFF);
        boolean actualContent = header[0] == 1;
        byte[] content = new byte[contentSize];
        if(!readFully(is, content, contentSize))break;
        if(actualContent)
            baos.write(content, 0, contentSize);
        else
            System.err.println(new String(content));
    }

    System.out.println(baos.toString());


}

/**
 * Read a given number of bytes from the stream and store them in the buffer.
 * 
 * @param   is
 *          The input stream to read from
 * @param   buffer
 *          The buffer to store it in
 * @size    size
 *          The number of bytes to read
 * 
 * @return  True if and only if all bytes were read.
 */
public static boolean readFully(InputStream is, byte[] buffer, int size) throws IOException{
    int totalAmountRead = 0;
    while(totalAmountRead < size){
        int amountJustRead = is.read(buffer, totalAmountRead, size-totalAmountRead);
        if(amountJustRead == -1)
            return false;
        totalAmountRead += amountJustRead;
    }

    return true;
}