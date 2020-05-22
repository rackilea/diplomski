public static void main(String[] args)
{
    String str = "(A(B(C(D(x)))))";
    findStuff(str);

}

public static void findStuff(String str){
    String pattern = "\\((.+)\\)";

    Pattern p = Pattern.compile(pattern);
    Matcher m = p.matcher(str);
    while (m.find())
    {
        String sub = m.group(1);
        System.out.println(" Word: " + sub);

        findStuff(sub);
    }
}