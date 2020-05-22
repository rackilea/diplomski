public class SquareComponent extends JPanel
{
    private Square square;

    public SquareComponent(Square square)
    {
        this.square = square;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        square.draw(g);
    }
}