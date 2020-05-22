public class DiePanel extends JPanel {
    private Die die;
    public void setDie(Die die) {
        this.die = die;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (die != null) {
            die.draw(g);
        }
    }
}