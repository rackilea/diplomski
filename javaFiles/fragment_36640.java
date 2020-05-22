public static String UrlTokenEncode(byte[] input) {
     try {
         if (input == null) {
         return null;
         }

         if (input.length < 1) {
             return null;
         }

         String base64Str = null;
         int endPos = 0;
         char[] base64Chars = null;

         base64Str = Base64.toBase64String(input);
         if (base64Str == null) {
             return null;
         }

         for (endPos = base64Str.length(); endPos > 0; endPos--) {
             if (base64Str.charAt(endPos - 1) != '=') {
                 break;
             }
         }

         base64Chars = new char[endPos + 1];
         base64Chars[endPos] = (char) ((int) '0' + base64Str.length() - endPos);
         for (int iter = 0; iter < endPos; iter++) {
             char c = base64Str.charAt(iter);
              switch (c) {
                 case '+':
                     base64Chars[iter] = '-';
                     break;
                 case '/':
                     base64Chars[iter] = '_';
                     break;
                 case '=':
                     base64Chars[iter] = c;
                 break;
                 default:
                     base64Chars[iter] = c;
                 break;
             }
          }
         return new String(base64Chars);
     } catch (Exception e) {
         return null;
     }
}