public class First extends JFrame {

    static JEditorPane ep;
    First() {
        ep = new JEditorPane();
        setSize(new Dimension(200, 200));
        ep.setText("I expect to receive some text.");
        add(ep);
        setVisible(true);
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
    }
}