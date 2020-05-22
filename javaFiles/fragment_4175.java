class Ideone
{
    public static void main (String[] args) throws java.lang.Exception
    {
        String str1 = "7-11";
        String str2 = "-11";

        String regex = "-";
        Pattern p = Pattern.compile(regex);
        Matcher m1 = p.matcher(str1);
        Matcher m2 = p.matcher(str2);
        System.out.println("Does str1 matches with regex using lookingAt method " + m1.lookingAt());
        System.out.println("Does str2 matches with regex using lookingAt method " + m2.lookingAt());
    }
}