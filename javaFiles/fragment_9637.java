private final byte[] readDataFromFile(short fileID, short fileOffset, short length, byte[] outBuffer, short outOffset) {
    final short selFileSize = getFileSize(fileID);
    if (selFileSize < (short)(fileOffset + length)) {
        ISOException.throwIt(ISO7816.SW_FILE_FULL); 
    }
    Util.arrayCopyNonAtomic(getFile(fileID), fileOffset, outBuffer, outOffset, length);
}