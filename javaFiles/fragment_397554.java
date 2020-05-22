byte b = -1;
int a = (int) (b & 0xF); // this returns 15, which is what I want
int c = (int) (b | 0); // this returns -1, which is essentially 0xFFFF
System.out.println("b:" + Integer.toBinaryString(b));
System.out.println("a:" + Integer.toBinaryString(a));
System.out.println("c:" + Integer.toBinaryString(c));
System.out.println("0xF:" + Integer.toBinaryString(0xF));