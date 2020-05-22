public String weave(String str1, String str2)
{
  if(str1.isEmpty() || str2.isEmpty()) {
    return str1 + str2;
  }
  return str1.substring(0, 1) + str2.substring(0, 1) + weave(str1.substring(1), str2.substring(1));
}