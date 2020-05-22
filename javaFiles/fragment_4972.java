public static void serialize(ByteBuffer bb, String r, String s) {
      bb.put(48);
      int start = bb.position();
      bb.put(0); // padding.
      bb.put(2);
      byte[] rBa = r.getBytes();
      bb.put((byte) rBa.length);
      bb.put(rBa);
      byte[] sBa = s.getBytes();
      bb.put((byte) sBa.length);
      bb.put(sBa);
      bb.put(start, (byte) (bb.position() - start - 1));
}