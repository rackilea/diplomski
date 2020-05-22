public static Pattern r = Pattern.compile("\\b8=\\w{3}(?:(?!8=\\w{3})[\\s\\S])*?10=\\w{3}\\|");
public static void main (String[] args) throws java.lang.Exception
{
   String str = "8=FIX.4.2|9=00394|35=8|49=FIRST|8=FIX.4.2|9=00394|35=8|56=MIDDLE|10=245|8=FIX.4.2|9=00394|35=8|49=LAST|56=HEMADTS|10=024|";
   match(str);
}
public static void match(String message) { //send to OMS
    Matcher m = r.matcher(message);
    System.out.println("MATCHED:");
    while (m.find()) {
       System.out.println(m.group());
    }
    System.out.println("UNMATCHED:");
    String[] unm = r.split(message);
    for (String s: unm) {
        System.out.println(s);  
    }
}