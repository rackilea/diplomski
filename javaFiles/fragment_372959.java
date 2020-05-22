public static void main(String... args) throws IOException {
    long[] sequence = new long[1024];
    Random rand = new Random(1);
    for (int i = 0; i < sequence.length; i+=2) {
        sequence[i] = (long) Math.pow(2, rand.nextDouble() * rand.nextDouble() * 61);
        // some pattern.
        sequence[i+1] = sequence[i] / 2;
    }
    testDeflator(sequence);
    testStopBit(sequence);
    testStopBitDeflator(sequence);
}

private static void testDeflator(long[] sequence) throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    DataOutputStream dos = new DataOutputStream(new DeflaterOutputStream(baos));
    for (long l : sequence)
        dos.writeLong(l);
    dos.close();
    System.out.println("Deflator used " + baos.toByteArray().length);
}


private static void testStopBit(long[] sequence) throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    for (long l : sequence)
        writeLong(baos, l);
    baos.close();
    System.out.println("Stop bit used " + baos.toByteArray().length);
}

private static void testStopBitDeflator(long[] sequence) throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    DataOutputStream dos = new DataOutputStream(new DeflaterOutputStream(baos));
    for (long l : sequence)
        writeLong(dos, l);
    dos.close();
    System.out.println("Stop bit & Deflator used " + baos.toByteArray().length);
}

public static void writeLong(OutputStream out, long value) throws IOException {
    while (value < 0 || value > 127) {
        out.write((byte) (0x80 | (value & 0x7F)));
        value = value >>> 7;
    }
    out.write((byte) value);
}