double n = Double.longBitsToDouble(0x7ff8000000000000L); // default NaN
double n2 = Double.longBitsToDouble(0x7ff8000000000100L); // also a NaN, but M != 0

System.out.printf("%X\n", Double.doubleToLongBits(n));
System.out.printf("%X\n", Double.doubleToRawLongBits(n));
System.out.printf("%X\n", Double.doubleToLongBits(n2));
System.out.printf("%X\n", Double.doubleToRawLongBits(n2));