public static boolean isBlank(String str) {
     int strLen;
     if ((str == null) || ((strLen = str.length()) == 0))
         return true;
     int strLen;
     for (int i = 0; i < strLen; ++i) {
        if (!(Character.isWhitespace(str.charAt(i)))) {
           return false;
        }
     }
   return true;
}