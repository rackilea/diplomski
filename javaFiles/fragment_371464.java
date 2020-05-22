public class testMatcher {
public static void main(String[] args){

    String source1="search engines";
    String source2="search engine";
    String subterm_1 = "engines";
    String subterm_2 = "engine";

    System.out.println(isContain(source1,subterm_1));
    System.out.println(isContain(source2,subterm_1));
    System.out.println(isContain(source1,subterm_2));
    System.out.println(isContain(source2,subterm_2));

}

    private static boolean isContain(String source, String subItem){
         String pattern = "\\b"+subItem+"\\b";
         Pattern p=Pattern.compile(pattern);
         Matcher m=p.matcher(source);
         return m.find();
    }

}