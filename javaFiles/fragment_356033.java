byte[] original = new byte[] { (byte) 255 };

System.out.println(new BigInteger(original).toString()); // prints "-1"

byte[] paddedCopy = new byte[original.length + 1];
for (int i = 0; i < original.length; i++) {
    paddedCopy[i + 1] = original[i];
}
System.out.println(new BigInteger(paddedCopy).toString()); // prints "255"