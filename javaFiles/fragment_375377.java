public class BitmapChunkWriter {

    private static final int BMP_WIDTH_OF_TIMES = 4;
    private static final int BYTE_PER_PIXEL = 3;

    private FileOutputStream fos;
    private byte[] dummyBytesPerRow;
    private boolean hasDummy;
    private int imageSize;
    private int fileSize;
    private int rowWidthInBytes;

    /**
     * Android Bitmap Object to Window's v3 24bit Bmp Format File
     * @param imageWidth
     * @param imageHeight
     * @param filePath
     * @return file saved result
     */
    public void writeHeader(int imageWidth, int imageHeight, String filePath) throws IOException {

        //image dummy data size
        //reason : the amount of bytes per image row must be a multiple of 4 (requirements of bmp format)
        dummyBytesPerRow = null;
        hasDummy = false;
        rowWidthInBytes = BYTE_PER_PIXEL * imageWidth; //source image width * number of bytes to encode one pixel.
        if (rowWidthInBytes % BMP_WIDTH_OF_TIMES > 0) {
            hasDummy = true;
            //the number of dummy bytes we need to add on each row
            dummyBytesPerRow = new byte[(BMP_WIDTH_OF_TIMES - (rowWidthInBytes % BMP_WIDTH_OF_TIMES))];
            //just fill an array with the dummy bytes we need to append at the end of each row
            for (int i = 0; i < dummyBytesPerRow.length; i++) {
                dummyBytesPerRow[i] = (byte) 0xFF;
            }
        }


        //the number of bytes used in the file to store raw image data (excluding file headers)
        imageSize = (rowWidthInBytes + (hasDummy ? dummyBytesPerRow.length : 0)) * imageHeight;
        //file headers size
        int imageDataOffset = 0x36;

        //final size of the file
        fileSize = imageSize + imageDataOffset;

        //ByteArrayOutputStream baos = new ByteArrayOutputStream(fileSize);
        ByteBuffer buffer = ByteBuffer.allocate(imageDataOffset);

        /**
         * BITMAP FILE HEADER Write Start
         **/
        buffer.put((byte) 0x42);
        buffer.put((byte) 0x4D);

        //size
        buffer.put(writeInt(fileSize));

        //reserved
        buffer.put(writeShort((short) 0));
        buffer.put(writeShort((short) 0));

        //image data start offset
        buffer.put(writeInt(imageDataOffset));

        /** BITMAP FILE HEADER Write End */

        //*******************************************

        /** BITMAP INFO HEADER Write Start */
        //size
        buffer.put(writeInt(0x28));

        //width, height
        //if we add 3 dummy bytes per row : it means we add a pixel (and the image width is modified.
        buffer.put(writeInt(imageWidth + (hasDummy ? (dummyBytesPerRow.length == 3 ? 1 : 0) : 0)));
        buffer.put(writeInt(imageHeight));

        //planes
        buffer.put(writeShort((short) 1));

        //bit count
        buffer.put(writeShort((short) 24));

        //bit compression
        buffer.put(writeInt(0));

        //image data size
        buffer.put(writeInt(imageSize));

        //horizontal resolution in pixels per meter
        buffer.put(writeInt(0));

        //vertical resolution in pixels per meter (unreliable)
        buffer.put(writeInt(0));

        buffer.put(writeInt(0));

        buffer.put(writeInt(0));

        fos = new FileOutputStream(filePath);
        fos.write(buffer.array());
    }


    public void writeChunk(Bitmap bitmap) throws IOException {


        int chunkWidth = bitmap.getWidth();
        int chunkHeight = bitmap.getHeight();

        //an array to receive the pixels from the source image
        int[] pixels = new int[chunkWidth * chunkHeight];
        //Android Bitmap Image Data
        bitmap.getPixels(pixels, 0, chunkWidth, 0, 0, chunkWidth, chunkHeight);

        //the number of bytes used in the file to store raw image data (excluding file headers)
        //int imageSize = (rowWidthInBytes + (hasDummy ? dummyBytesPerRow.length : 0)) * height;

        int chunkSize = (rowWidthInBytes + (hasDummy ? dummyBytesPerRow.length : 0)) * chunkHeight;
        ByteBuffer buffer = ByteBuffer.allocate(chunkSize);

        int row = chunkHeight;
        int col = chunkWidth;
        int startPosition = (row - 1) * col;
        int endPosition = row * col;
        while( row > 0 ){
            for(int i = startPosition; i < endPosition; i++ ){
                buffer.put((byte)(pixels[i] & 0x000000FF));
                buffer.put((byte)((pixels[i] & 0x0000FF00) >> 8));
                buffer.put((byte)((pixels[i] & 0x00FF0000) >> 16));
            }
            if(hasDummy){
                buffer.put(dummyBytesPerRow);
            }
            row--;
            endPosition = startPosition;
            startPosition = startPosition - col;
        }

        fos.write(buffer.array());
    }

    public void finish() throws IOException {
        fos.close();
    }

    /**
     * Write integer to little-endian
     * @param value
     * @return
     * @throws IOException
     */
    private static byte[] writeInt(int value) throws IOException {
        byte[] b = new byte[4];

        b[0] = (byte)(value & 0x000000FF);
        b[1] = (byte)((value & 0x0000FF00) >> 8);
        b[2] = (byte)((value & 0x00FF0000) >> 16);
        b[3] = (byte)((value & 0xFF000000) >> 24);

        return b;
    }

    /**
     * Write short to little-endian byte array
     * @param value
     * @return
     * @throws IOException
     */
    private static byte[] writeShort(short value) throws IOException {
        byte[] b = new byte[2];

        b[0] = (byte)(value & 0x00FF);
        b[1] = (byte)((value & 0xFF00) >> 8);

        return b;
    }
}