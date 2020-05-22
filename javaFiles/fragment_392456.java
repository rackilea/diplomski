public void test() {
    BigInteger a = new BigInteger(new byte[]{(byte) 0x00, (byte) 0x00, (byte) 0xff});
    BigInteger b = new BigInteger(new byte[]{(byte) 0x00, (byte) 0x00, (byte) 0xff});

    System.out.println(a.toString(16) + "+" + b.toString(16) + "=" + a.add(b).toString(16));
}