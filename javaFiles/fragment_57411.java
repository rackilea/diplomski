public void WriteCompressedData(BufferedOutputStream outStream, byte[] message) {
    byte currentByte;
    int nBytes = message.length;
    int iByte = 0;
    int iBit = 7;
    if (nBytes > 0) {
        currentByte = message[0];
    } else {
        currentByte = (byte) 0;
    }
    // Original method code up until the following line
    dctArray3 = dct.quantizeBlock(dctArray2, JpegObj.QtableNumber[comp]);
    // ******************** our stuff *******************
    if (iByte < nBytes) {
        int bit = (currentByte >> iBit) & 1;
        iBit--;
        if (iBit == -1) {
            iBit = 7;
            iByte++;
            if (iByte < nBytes) {
                currentByte = message[iByte];
            }
        }
        dctArray3[23] = (dctArray3[23] & 0xfffffffe) | bit;
    }
    // **************************************************
    Huf.HuffmanBlockEncoder(outStream, dctArray3, lastDCvalue[comp], JpegObj.DCtableNumber[comp], JpegObj.ACtableNumber[comp]);
    ...
}