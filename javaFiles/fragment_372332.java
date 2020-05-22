public static void main(String[] args) {
    String str1 = "site:www.example.com \"hello world\" \"hi abc\" where are you";
    String str2 = "\"hello world\" \"hi abc\" site:www.example.com where are you";

    ExtractResponse response1 = extractSite(str1);
    System.out.println(response1.newStr);
    System.out.println(response1.site);

    ExtractResponse response2 = extractSite(str2);
    System.out.println(response2.newStr);
    System.out.println(response2.site);
}