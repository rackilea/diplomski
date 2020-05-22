public String or(String a, String b) throws UnsupportedEncodingException {
    final String charsetName = "US-ASCII";
    BitSet aBitSet = BitSet.valueOf(a.getBytes(charsetName));
    aBitSet.or(BitSet.valueOf(b.getBytes(charsetName)));
    return new String(aBitSet.toByteArray(), Charset.forName(charsetName));
}