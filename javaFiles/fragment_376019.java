public static void main(String[] args) {
    System.out.println(lastTwo("coding"));
    System.out.println(lastTwo("cat"));
    System.out.println(lastTwo("ab"));
    System.out.println(lastTwo("a"));
}
public static String lastTwo(String str) {

    int strLength = str.length();
    if(strLength<2)
        return str;

    String last = str.substring(strLength-1,strLength);
    String bLast = str.substring(strLength-2,strLength-1);
    return str.substring(0, strLength-2)+last+bLast;
}