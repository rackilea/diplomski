// holds a row of data
@SuppressWarnings("serial")
class RowPanel extends JPanel {
    private static final int COLS = 20;
    private JTextField txtDirMod = new JTextField(COLS);
    private JTextField txtNomMod = new JTextField(COLS);
    private ProbMain2 probMain2;
    private int minorStrut = 3;
    private int majorStrut = 6;

    // TODO: add tool tips, ...
    public RowPanel(ProbMain2 probMain2) {
        this.probMain2 = probMain2;
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        setBorder(BorderFactory.createEmptyBorder(minorStrut, minorStrut, minorStrut, minorStrut));
        add(new JLabel("Directorio"));
        add(Box.createHorizontalStrut(minorStrut));
        add(txtDirMod);
        add(Box.createHorizontalStrut(majorStrut));
        add(new JLabel("Nombre"));
        add(Box.createHorizontalStrut(minorStrut));
        add(txtNomMod);
        add(Box.createHorizontalStrut(majorStrut));
        add(new JButton(new AnadirAction()));
        add(Box.createHorizontalStrut(minorStrut));
        add(new JButton(new EliminarAction()));
    }

    // to extract data held in the JPanel
    public String getDir() {
        return txtDirMod.getText();
    }

    public String getNom() {
        return txtNomMod.getText();
    }

    private class AnadirAction extends AbstractAction {
        public AnadirAction() {
            super("Anadir");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // add new RowPanel to the main GUI
            probMain2.addRowPanel();
        }
    }

    private class EliminarAction extends AbstractAction {
        public EliminarAction() {
            super("Eliminar");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // tell main GUI to remove *this* RowPanel object
            probMain2.removeRowPanel(RowPanel.this);
        }
    }
}