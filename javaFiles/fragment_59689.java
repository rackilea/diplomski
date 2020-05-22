public void getBits(int number){

      String bits = "";
      for (int i = 0; i < 16; i++) {
          bits = (number & 1) + bits;
          number >>= 1;
      }
      System.out.println("The bits are " + bits);
  }