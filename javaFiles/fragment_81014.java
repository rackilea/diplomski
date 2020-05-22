public static void main(String[] args)
{
    String str = "C1<C2, C3<T1>>.C4<T2>.C5";
    Pattern pat = Pattern.compile("\\w+(<[^>]+>+)?");
    Matcher mat = pat.matcher(str);

    while(mat.find()) {
        System.out.println(mat.group());
    }    
}