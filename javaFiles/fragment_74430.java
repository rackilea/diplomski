public class LetterPrint
{
    private final static int charsInLine = 4;

    private final int totalLines;
    private final int consecLines;

    public LetterPrint(int totalLines, int consecLines)
    {
        this.totalLines = totalLines;
        this.consecLines = consecLines;
    }

    public void beginPrinting()
    {
        for (int lineNumber = 0; lineNumber < totalLines; lineNumber++)
        {
            char currentChar = getChar(lineNumber);
            for (int charNumber = 0; charNumber < charsInLine; charNumber++)
            {
                System.out.print(currentChar);
            }
            System.out.println();
        }
    }

    private char getChar(int lineNumber)
    {
        if ((lineNumber / consecLines) % 2 == 0)
        {
            return 'A';
        }
        return 'B';
    }
}