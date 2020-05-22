static String encode(String word){
    word = word.toLowerCase();
    char[] c = word.toCharArray();
    char[] d = word.toCharArray();
    //")"
    char close = 41;
    //"("
    char open = 40;
    for (int i = 0; i < c.length; i++) {
      int count = 0;
      for (int j = 0; j < c.length; j++) {
        if(c[i] == c[j]) {
          count++;
        }
      }
      if(count > 1){
        d[i] = close;
      }
      else if (count == 1){
        d[i] = open;
      }
    }
    String string = new String(d);
    return string;
  }