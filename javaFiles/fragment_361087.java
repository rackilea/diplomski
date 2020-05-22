package test;

public class Test {

    public static void main(String[] args) throws Exception {
        String latexText = "J{\\\"o}rg";
        String normalText = replaceBibtexMutatedVowels(latexText);
        System.out.println(latexText);
        System.out.println(normalText);
    }

    public static String replaceBibtexMutatedVowels(String str) {
        CharSequence target = "{\\\"o}";
        CharSequence replacement = "ö";
        str = str.replace(target, replacement);
        return str;
    }

}