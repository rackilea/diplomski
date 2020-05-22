public static void writeLong(OutputStream out, long value) throws IOException {
   while(value < 0 || value > 127) {
        out.write((byte) (0x80 | (value & 0x7F)));
        value = value >>> 7;
   }
   out.write((byte) value);
}

public static long readLong(InputStream in) throws IOException {
   int shift = 0;
   long b;
   long value = 0;
   while((b = in.read()) >= 0) {
      value += (b & 0x7f) << shift;
      shift += 7;
      if ((b & 0x80) == 0) return value;
   }
   throw new EOFException();
}