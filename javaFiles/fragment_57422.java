String getByteString(byte b) {
    StringBuffer buf = new StringBuffer();
    String digit=Integer.toHexString(b &0xff);
    buf.append(digit);
    if (digit.length()<2) buf.append('0');
    return buf.toString();
}