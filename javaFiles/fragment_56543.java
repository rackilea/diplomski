byte[] keyByte = DatatypeConverter.parseHexBinary("007e151628aed2a6abf7158809cf4f3c");

for(int i = 0; i < 256; i++){
    keyByte[0] = (byte)i;
    ...
}