public static String concat(String a, String b)
{
    if(a.length() == 0){
        return b;
    }

    if(b.length() == 0){
        return a;
    }

    String a1 = "" + a.charAt(0);
    int i = 1;
    while(i < a.length() && a.charAt(i) == a.charAt(0))
    {
        a1 += a.charAt(i++);
    }

    String b1 = "" + b.charAt(0);
    i = 1;
    while(i < b.length() && b.charAt(i) == b.charAt(0))
    {
        b1 += b.charAt(i++);
    }

    return a1 + b1 + concat(a.substring(a1.length()), b.substring(b1.length()));
}