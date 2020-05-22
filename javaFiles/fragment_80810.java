public byte[] IntArrayToByteArray(int[] Iarr){
       byte[] bytes = new byte[Iarr.length];
       for (int i = 0; i < Iarr.length; i++) {
         bytes[i] = (byte)  (Iarr[i] & 0xFF);
       }
      return bytes;
    }