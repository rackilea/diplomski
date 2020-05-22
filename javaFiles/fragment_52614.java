public String[] componizePath(String path)
   {
      ArrayList<String> parts = new ArrayList<String>();  

      int index = 0;
      while(index < path.length())
      {
         if(path.charAt(index) == '/' || index == path.length()-1)
         {
            parts.add(path.substring(0, index+1));
         }
         index++;
      }

      return parts.toArray(new String[0]);
   }