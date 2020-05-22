public String readString()
{
    ...  // ignore spaces at start
    do
    {
        res.appendCodePoint(c);
        c = read();
    } while (!isSpaceChar(c));  // STOPS reading if it got a space
    return res.toString();
}