public static double decrypt(String encryptedNumber) {
   StringBuilder builder = new StringBuilder();
   int i = 0;
   String[] encNumElements = encryptedNumber.toLowerCase().split("");
   for (String element : encNumElements) {
      int foundAt = Arrays.binarySearch(conversionTable, new String[]{element, ""}, new Comparator<String[]>() {
            @Override
            public int compare(String[] arg0, String[] arg1) {
               return arg0[0].compareTo(arg1[0]);
            }               
      });
      if (foundAt >= 0) {
         builder.append(conversionTable[foundAt][1]);
      } else {
         // assuming a decimal point here since it's not on the list
         builder.append('.');
      }
   }

   double d = Double.parseDouble(builder.toString());
   return d;
}