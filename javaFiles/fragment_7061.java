public static double decrypt(String encryptedNumber) {
      StringBuilder builder = new StringBuilder();
      for (char ch : encryptedNumber.toLowerCase().toCharArray()) {
         if (ch == '.') {
            builder.append('.');
         } else {
            builder.append(ch - 'a');
         }
      }
      return Double.parseDouble(builder.toString());
   }