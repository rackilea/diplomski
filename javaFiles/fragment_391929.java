byte [] encryptOrDecrypt(byte[] key, byte[] input){
    byte [] result = new byte[input.length];
    for(int i=0; i<input.length; i++) {
        result[i] = input[i] ^ key[i % key.length];
    }
    return result;
}