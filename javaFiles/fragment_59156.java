class Encoder {
    public Color[] encode(byte[] signedBytes) {
        return encode(unsign(signedBytes));
    }

    public Color[] encode(int[] unsignedBytes) {
        //...
    }

    private int[] unsign(byte[] signesBytes) {
        //...
    }
}

class Decoder {
    public byte[] decode(Color[] colors) {
        //receive unsigned bytes from colors

        return sign(unsignedBytes);
    }

    private byte[] sign(int[] unsignedBytes) {
        //...
    }
}