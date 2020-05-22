public static String removeBadChars(String s) {
  if (s == null) return null;
  StringBuilder sb = new StringBuilder();
  for(int i=0;i<s.length();i++){ 
    if (Character.isHighSurrogate(s.charAt(i))) continue;
    sb.append(s.charAt(i));
  }
  return sb.toString();
}