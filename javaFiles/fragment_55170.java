/**
 * Test if a character is valid in xml character content. See
 * http://www.w3.org/TR/REC-xml#NT-Char
 */
static boolean isBadChar ( char ch )
{
    return ! (
        Character.isHighSurrogate(ch) ||
        Character.isLowSurrogate(ch) ||
        (ch >= 0x20 && ch <= 0xD7FF ) ||
        (ch >= 0xE000 && ch <= 0xFFFD) ||
        (ch >= 0x10000 && ch <= 0x10FFFF) ||
        (ch == 0x9) || (ch == 0xA) || (ch == 0xD)
    );
}