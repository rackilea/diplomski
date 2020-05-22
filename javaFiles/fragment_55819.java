public class MyFrame extends JFrame implements ComponentListener {

    @Override
    public void componentResized(ComponentEvent e) {
        // re compute?
        repaint();
    }
}