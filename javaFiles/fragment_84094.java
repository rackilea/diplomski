class GetCoordinate extends JLabel {
    public GetCoordinate() {
        setText("Foo!");
        // Let's not try to do this here anymore...
//        System.out.println("Coordinate: " + this.getBounds());
    }

    public void printBounds() // <-- Added this method
    {
        System.out.println("Coordinate: " + this.getBounds());
    }
}

public class Grid extends JFrame {
    public Grid() {
        setLayout(new GridBagLayout());
        GridBagLayout m = new GridBagLayout();
        Container c = getContentPane();
        c.setLayout(m);
        GridBagConstraints con = new GridBagConstraints();

        // construct the JPanel
        final JPanel pDraw = new JPanel();
        m.setConstraints(pDraw, con);
        final GetCoordinate content = new GetCoordinate();
        pDraw.add(content);
        c.add(pDraw);

        pack();
        setVisible(true);
        content.printBounds();  // <-- Added this
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Grid();
            }
        });
    }
}