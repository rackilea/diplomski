public static String correctName(String name) {
  StringBuilder nameBuilder = new StringBuilder();
  for (char nameChar:name.charArray())
     if (isValidXml(nameChar))          // some magic left to do ;)
         nameBuilder.append(nameChar);
  return nameBuilder.toString();
}