public static String formatISBNWithHyphens(String isbn) {
    // original isbn:  123456789
    // new isbn :      1-234-56789-X
    char isbn10 = getCheckSum(isbn);// this method get sum and put 10th char in isbn


    String isbn10Str = isbn + Character.toString(isbn10); // Edit: You want the whole ISBN, not just the last char.
    String[] cStr = new String[isbn.length()];
    String isbnStr = ""; // EDIT: Initialize to empty string instead of null

    for (int i = 0; i < isbn10Str.length(); i++){
        cStr[i] = Character.toString(isbn10Str.charAt(i));
        if (i == 0 || i == 3 || i == 8 ) {
            cStr[i] += "-"; // Edit: Adding a char to another char will result in a different char. Not a concatenated string. So use Strings instead.
         }

         isbnStr += cStr[i];
    }
    return isbnStr;
}