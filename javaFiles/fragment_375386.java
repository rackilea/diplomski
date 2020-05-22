public static String quotemeta(String str)
{
  if (str == null)
  {
    throw new IllegalArgumentException("String cannot be null");
  }

  int len = str.length();
  if (len == 0)
  {
    return "";
  }

  StringBuffer sb = new StringBuffer(len * 2);
  for (int i = 0; i < len; i++)
  {
    char c = str.charAt(i);
    if ("\\[](){}.*+?$^|#/".indexOf(c) != -1)
    {
      sb.append("\\");
    }
    sb.append(c);
  }
  return sb.toString();
}