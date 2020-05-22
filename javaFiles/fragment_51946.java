public static String printTriangle (int count) 
  {
      if( count <= 0 ) return "";

      String p="";
      for (int i=0; i<count; i++)
      {
        p = p + "*";
      }

      p += "\n";
      return p + printTriangle(count - 1);
   }