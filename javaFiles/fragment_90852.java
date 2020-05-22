public static String[] getSubStrings(String string){
      List<String> result = new ArrayList<String>();
      int i, c, length;
      length = string.length();   
      for( c = 0 ; c < length ; c++ )
      {
         for( i = 1 ; i <= length - c ; i++ )
         {
            result.add(string.substring(c, c+i));
         }
      }
      return result.toArray(new String[result.size()]);
}