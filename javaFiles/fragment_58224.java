@SuppressWarnings("serial")
public class Type_Client extends Applet {

    private String typed = "";

    private KeyAdapter adapter = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            char ch = e.getKeyChar();
            if (ch >= ' ' && ch <= '~') {
                typed += ch;
                repaint();
            }
        }
    };

    @Override
    public void start() {
        addKeyListener(adapter);
    }

    @Override
    public void stop() {
        removeKeyListener(adapter);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawString(typed, 10, 10);
    }
}