public static String fixDecimal (Double d) {
    String  str = "" + d;
    int    nDot = str.indexOf ('.');

    if (nDot == -1)
      return str;

    for (int i = nDot, j=0, last ='?'; i < str.length (); ++i) {
      j = str.charAt (i) == last ? j+1 : 0;

      if (j > 3)
        return String.format ("%."+(i-nDot-j-1)+"f", d);

      last = str.charAt (i);
    }

    return str;
  }