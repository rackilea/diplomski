public boolean containsCaseInsensitive(String s, List<String> l){
     for (String string : l){
        if (string.equalsIgnoreCase(s)){
            return true;
         }
     }
    return false;
  }