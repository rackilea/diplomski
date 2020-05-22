class GetCoordinate extends JLabel {
    public GetCoordinate() {
        setText("Foo!");
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
        pDraw.add(new GetCoordinate()); // call new class to generate the
                                        // coordinate
        c.add(pDraw);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Grid();
            }
        });
    }
}