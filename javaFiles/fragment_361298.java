for (int row = 0; row < mtrx.length; row++)
{
    String words = s1.next();    // will scan each row of the file
    for (int col = 0; col < mtrx[row].length; col++)
    {
        char ch = words.charAt(col);    // will put each character into array
        mtrx[row][col] = String.valueOf(ch);
    }
}