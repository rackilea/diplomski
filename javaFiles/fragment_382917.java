public static void main (String[] args) throws java.lang.Exception
{
    System.out.println(fetchMatch("test", 0));
    System.out.println(fetchMatch("one&test", 0));
    System.out.println(fetchMatch("&test", 0));
}
public static String fetchMatch(String s, int groupId)
{
    Pattern pattern = Pattern.compile("^[^&]+");
    Matcher matcher = pattern.matcher(s);
    if (matcher.find()){
        return matcher.group(groupId); 
    } 
    return "ERROR: NOT MATCHED";
}