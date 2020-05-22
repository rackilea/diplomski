class FloatToBinary { 
      public static void main( String ... args ) { 

      int BitRep =   Float.floatToIntBits(12345.12346f); //Bit Representation of the Float
      System.out.println(BitRep); //1178657918

      String BinString = Integer.toBinaryString(BitRep); //Binary representation in String
      System.out.println(BinString); //1000110010000001110010001111110



             }
        }