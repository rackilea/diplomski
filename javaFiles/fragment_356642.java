public byte[] decrypt(int[] data, int[] key) { 
    int x = data[0]; 
    int y = data[1]; 
    ByteBuffer decrypted = ByteBuffer.allocate(8);
    int sum = 0xC6EF3720; //32*delta
    int constant = 0x9e3779b9; //magic constant

    for (int k = 0; k < 32; ++k) { 
        y -= (x << 4 & 0xfffffff0) + key[2] ^ x + sum ^ (x >> 5 & 0x7ffffff) + key[3]; 
        x -= (y << 4 & 0xfffffff0) + key[0] ^ y + sum ^ (y >> 5 & 0x7ffffff) + key[1]; 
        sum -= constant; 
    }
    decrypted.putInt(x); 
    decrypted.putInt(y);
    return decrypted.array();
}