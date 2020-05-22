public String cammelCase(String sampleString, String separator) {
  String[] split = sampleString.split(separator);

  if (split.length < 2) return sampleString;

  for (int i =  1; i < split.length; i++) {
   split[i] = split[i].substring(0,1).toUpperCase() + split[i].substring(1);
  }

  String retStr = "";
  for (int i =0; i < split.length; i++) {
    resStr += split[i];
    if (i != split.length - 1) {
      retStr += separator;
     }
  }
 return retStr;
}