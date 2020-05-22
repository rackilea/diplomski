int a = 0x12345678;
int b = 0x12345678;
System.out.println("a*b as int multiplication (overflown) [DECIMAL]: " + (a*b));
System.out.println("a*b as int multiplication (overflown) [HEX]: 0x" + Integer.toHexString(a*b));
System.out.println("a*b as long multiplication (overflown) [DECIMAL]: " + ((long)a*b));
System.out.println("a*b as long multiplication (overflown) [HEX]: 0x" + Long.toHexString((long)a*b));