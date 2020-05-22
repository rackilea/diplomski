public class MovimentoAnimator extends JPanel
{
    private List<Movimento> movimentos = new ArrayList<Movimento>();

    public void addMovimento(Movimento movimento)
    {
        movimentos.add( movimento );
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        for (Movimento movimento: movimentos
        {
            movimento.paintMe( g );
        }
    }
}