double d = 500.0;

long l1 = Double.doubleToLongBits(d);
long l2 = Long.reverseBytes(l1);

System.out.println(Double.longBitsToDouble(l1));
System.out.println(Double.longBitsToDouble(l2));