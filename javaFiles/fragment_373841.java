for(int i = 0; i <= s1.length() - 4; i++)
{
    String subStr = s1.substring(i, i + 4);
    if(s2.contains(subStr) && s3.contains(subStr))
    {
        System.out.println(subStr + " is in all 3 lists.");
    }
}
System.out.println("Task Complete.");