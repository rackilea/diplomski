public static void main(String[] args) {

    String str1 = "Chapter 1: Home";
    String str2 = "Chapter 2: Revenge";
    String str3 = "Chapter 3c: Return";
    String str4 = "Chapter 1:Return";

    System.out.println(validChapter(str1)); // true
    System.out.println(validChapter(str2)); // true
    System.out.println(validChapter(str3)); // false
    System.out.println(validChapter(str4)); // false
}