public void test() {
    // Binary - 100000000000000100001100011
    //          ^ This is bit 26
    long value = 0x4000863; 
    // Binary - ‭1000000000000000000000000000000000000000000000000000000000000000‬
    //          ^ THIS is bit 63
    long bigger = 0x8000000000000000L;
    BigInteger test = new BigInteger(Long.toString(value));
    System.out.println("L:" + Long.toBinaryString(value) + "\r\nB:" + test.toString(2) + "\r\nB63:" + test.testBit(63));
    test = new BigInteger(Long.toString(bigger));
    System.out.println("L:" + Long.toBinaryString(bigger) + "\r\nB:" + test.toString(2) + "\r\nB63:" + test.testBit(63));
}