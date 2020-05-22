/**
     * Test if a character is valid in xml character content. See
     * http://www.w3.org/TR/REC-xml#NT-Char
     */
    private boolean isBadChar ( char ch )
    {
        return ! (
            (ch >= 0x20 && ch <= 0xFFFD ) ||
            (ch == 0x9) || (ch == 0xA) || (ch == 0xD)
            );
    }