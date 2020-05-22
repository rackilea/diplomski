public static String encDec(String input, String password) {

      byte[] in = input.getBytes();
      byte[] key = password.getBytes();
      byte[] result = new byte[in.length];
      int k = 0;
      for (int i = 0; i < in.length; i++) {
         result[i] = (byte)(in[i] ^ key[k]);
         k++;
         if (k == key.length) 
           k=0;
      }

      return new String(result);
    }