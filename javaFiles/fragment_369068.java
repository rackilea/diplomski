public static void main(String args[])
{
    String test = "test";
    String regex = "test";
    Pattern pattern = Pattern.compile(regex);

    Matcher matcher = pattern.matcher(test);
    if(matcher.find())
        System.out.println("found");

    if(matcher.find())
        System.out.println("found2");

}