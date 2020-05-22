class Mva { // Multi-valued attribute
    private final byte[] data;
    public Mva(byte[] data) { this.data = data; }
    @Override
    public int hashCode() {
        // return CRC similar to your generateCheckSum
    }
    @Override
    public boolean equals(Object other) {
        // Cast other to Mva, and compare individual values in data[]
    }
}