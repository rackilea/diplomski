public class Main {
    public static void main(String[] args) {
        String str1 = "1, 'Test data', 'other data', '2016-02-02'";
        String str2 = "2, 'Another row, with a comma', 'other data', '2016-01-02'";
        String str3 = "3, 'Another row, with a comma and \' - more data ',' other data ',' 2016-01-01 '";


        splitAndPrintString(str1);
        splitAndPrintString(str2);
        splitAndPrintString(str3);
    }

    public static void splitAndPrintString(String str) {
        System.out.println("String: " + str + " splits to: ");
        String splitStr[] = str.split("(,')|(, ')");
        for(String s: splitStr) {
            System.out.println(s.replaceAll("'$", ""));
        }
        System.out.println("");
    }
}