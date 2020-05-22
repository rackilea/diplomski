String getStringFromSb(StringBuilder sb, int stringLength)
{
  String returnStr = sb.substring(0, stringLength);
  sb.delete(0, stringLength);
  return returnStr;
}