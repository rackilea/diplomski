/**
     * Creates the appropriate HSSFWorkbook / XSSFWorkbook from
     *  the given InputStream.
     * Your input stream MUST either support mark/reset, or
     *  be wrapped as a {@link PushbackInputStream}!
     */
    public static Workbook create(InputStream inp) throws IOException, InvalidFormatException {
            // If clearly doesn't do mark/reset, wrap up
            if(! inp.markSupported()) {
                    inp = new PushbackInputStream(inp, 8);
            }

            if(POIFSFileSystem.hasPOIFSHeader(inp)) {
                    return new HSSFWorkbook(inp);
            }
            if(POIXMLDocument.hasOOXMLHeader(inp)) {
                    return new XSSFWorkbook(OPCPackage.open(inp));
            }
            throw new IllegalArgumentException("Your InputStream was neither an OLE2 stream, nor an OOXML stream");
    }