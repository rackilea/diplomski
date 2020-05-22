/**
     * Attempts to read in the next block data header (if any).  If
     * canBlock is false and a full header cannot be read without possibly
     * blocking, returns HEADER_BLOCKED, else if the next element in the
     * stream is a block data header, returns the block data length
     * specified by the header, else returns -1.
     */
    private int readBlockHeader(boolean canBlock) throws IOException {
         // code deleted
                int tc = in.peek();
                switch (tc) {
                    case TC_BLOCKDATA:
         // code deleted
                    default:
                        if (tc >= 0 && (tc < TC_BASE || tc > TC_MAX)) {
                            throw new StreamCorruptedException(
                                String.format("invalid type code: %02X",
                                tc));
                        }
                        return -1;
    }