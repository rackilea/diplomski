String text = ...;
System.out.println("The vowel a appears " + count(text, 'a') + " times.");
System.out.println("The vowel e appears " + count(text, 'e') + " times.");
System.out.println("The vowel i appears " + count(text, 'i') + " times.");
System.out.println("The vowel o appears " + count(text, 'o') + " times.");
System.out.println("The vowel u appears " + count(text, 'u') + " times.");

...

private static int count(String text, char charToCount) {
    int count = 0;
    for (int i = 0; i < text.length(); i++) {
        if (text.charAt(i) == charToCount) {
            count++;
        }
    }
    return count;
}