/**
 * Converts this string to a new character array.
 *
 * @return  a newly allocated character array whose length is the length
 *          of this string and whose contents are initialized to contain
 *          the character sequence represented by this string.
 */
public char[] toCharArray() {
    char result[] = new char[count]; // <-- Here is the initialization :)
    getChars(0, count, result, 0);
    return result;
}