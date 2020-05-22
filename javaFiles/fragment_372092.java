String s1Binary = "01110100011001010111001101110100";
String s2Binary = "01110011011000010110110101110000011011000110010101001010010000010101011001000001";
BigInteger b1 = new BigInteger(s1Binary, 2);
BigInteger b2 = new BigInteger(s2Binary, 2);
System.out.println(b1.and(b2).toString(2));
System.out.println(b1.or(b2).toString(2));