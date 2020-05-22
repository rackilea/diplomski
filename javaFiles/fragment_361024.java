public class AeroResize extends JFrame {

    public AeroResize(final String title) {

        super(title);
        initUI();
    }

    private void initUI() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        final JButton minimize = new JButton("Minimize");
        final JButton maximize = new JButton("Maximize");
        final JButton normal = new JButton("Normal");
        add(normal);
        add(minimize);
        add(maximize);
        pack();

        minimize.addActionListener(e -> {
            setVisible(false);
            setExtendedState(getExtendedState() | JFrame.ICONIFIED);
            setVisible(true);
//          setLocation(getLocationOnScreen()); // Needed only for the preview. See comments section below.
        });
    }

    public static void main(final String[] args) {

        SwingUtilities.invokeLater(() -> new AeroResize("AeroSnap and the Frame State").setVisible(true));
    }
}