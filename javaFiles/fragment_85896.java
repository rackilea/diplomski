public class FancyCaret extends DefaultCaret {
    private static final Logger logger = Logger.getLogger(FancyCaret.class.getName());

    protected synchronized void damage(Rectangle r) {
        if (r == null)
            return;

        x = r.x;
        y = r.y;
        height = r.height;
        if (width <= 0)
            width = getComponent().getWidth();

        repaint(); // calls getComponent().repaint(x, y, width, height)
    }

    @Override
    public void paint(Graphics g) {
        JTextComponent comp = getComponent();
        if (comp == null)
            return;

        int dot = getDot();
        Rectangle r;
        char dotChar;
        try {
            r = comp.modelToView(dot);
            if (r == null)
                return;
            dotChar = comp.getText(dot, 1).charAt(0);
        } catch (Exception e) {
            logger.info(e);
            return;
        }

        if ((x != r.x) || (y != r.y)) {
            repaint(); // erase previous location of caret
            x = r.x; // Update dimensions (width gets set later in this method)
            y = r.y;
            height = r.height;
        }

        if (dotChar == '\n') {
            width = r.height / 2;
            if (isVisible())
                g.fillRect(r.x, r.y, width, r.height);
            return;
        }

        g.setColor(comp.getCaretColor());
        g.setXORMode(comp.getBackground()); // do this to draw in XOR mode

        width = g.getFontMetrics().charWidth(dotChar);
        if (isVisible())
            g.fillRect(r.x, r.y, width, r.height);
    }
}