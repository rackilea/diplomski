int counter = 0;
for (byte a = -128; counter <= 256; ++a, ++counter)
{
   byte b = (byte)(Integer.valueOf(Integer.toBinaryString(a & 0xFF), 2) & 0xFF);
   System.out.println(a+" == "+b);
}