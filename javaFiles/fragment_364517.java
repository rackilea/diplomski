String[] arrayofbits = new String[256];
  byte bytes;
  String s;

  for (int i = 0; i < 256; i++) {

   bytes = (byte) i;

   s = (Integer.toBinaryString(0xFF & bytes)).replaceAll(".*(.{8})$", "$1");
   s = StringUtils.leftPad(s, 8, "0");
   arrayofbits[i] = s;
   System.out.println("index " + i + " " + s + "\n");


  }