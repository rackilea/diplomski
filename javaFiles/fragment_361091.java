try {
     Integer b = Integer.valueOf(hexString,16);
     Integer.toBinaryString(b);
   } catch (NumberFormatException ee) {
     ee.printStackTrace();
   }