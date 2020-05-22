private static float[] bytesToFloats(byte[] bytes) {
    float[] floats = new float[bytes.length / 2];
    for(int i=0; i < bytes.length; i+=2) {
        floats[i/2] = bytes[i] | (bytes[i+1] << 8);
    }
    return floats;
}