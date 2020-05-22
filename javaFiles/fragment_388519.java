private static String origChars;
public static void reverse() {
    if (origChars.length() <= 1)
        System.out.print(origChars);
    else {
        System.out.print(origChars.charAt(origChars.length() - 1));
        origChars = origChars.substring(0, origChars.length() - 1);
        reverse();
    }
}