public String endX(String str) {
  if(str.length() == 0)
    return "";
  return str.startsWith("x") ? 
    endX(str.substring(1)) + "x" :
    String.valueOf(str.charAt(0)) + endX(str.substring(1));
}