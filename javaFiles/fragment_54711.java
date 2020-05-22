public class Board
{
    private Color theColor;

    public Board(int x, int y)
    {
    }

    public void SetColorAt(int x, int y, Color color) {
        theColor = color;
    }

    public Color GetColorAt(int x, int y) {
        return theColor;
    }
}