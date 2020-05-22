private static BufferedImage readImage(InputStream stream, IconDirEntry entry) throws IOException {
        byte[] bytes = new byte[entry.data];
        stream.read(bytes);
        if (!isPNG(bytes)) {
            setLittleInt(bytes, 8, entry.height);
            byte[] bmp = makeBitmapFileHeader(bytes);
            bytes = PrimArrays.concat(bmp, bytes);
        }
        if (DEBUG_FILE.exists() && entry.width == 32)
            new SerializerByteArray().toFile(bytes, DEBUG_FILE);
        return ImageIO.read(new ByteArrayInputStream(bytes));
    }