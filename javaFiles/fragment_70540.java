import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

@SuppressWarnings("serial")
public class ProbMain2 extends JPanel {
    private static final int PREF_W = 800;
    private static final int PREF_H = 500;
    // holds the rows, has grid layout with variable number of rows and one column:
    private JPanel rowHolderPanel = new JPanel(new GridLayout(0, 1));
    private List<RowPanel> rowPanelList = new ArrayList<>();

    public ProbMain2() {
        // panel below holds the rowHOlderPanel at the PAGE_START position
        JPanel borderLayoutPanel = new JPanel(new BorderLayout());
        borderLayoutPanel.add(rowHolderPanel, BorderLayout.PAGE_START);
        JScrollPane scrollPane = new JScrollPane(borderLayoutPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        addRowPanel();

        setLayout(new BorderLayout());
        add(scrollPane);
    }

    public void addRowPanel() {
        RowPanel rowPanel = new RowPanel(this);
        rowPanelList.add(rowPanel);
        rowHolderPanel.add(rowPanel);
        rowHolderPanel.revalidate();
        rowHolderPanel.repaint();
    }

    public void removeRowPanel(RowPanel row) {
        rowPanelList.remove(row);
        rowHolderPanel.remove(row);
        rowHolderPanel.revalidate();
        rowHolderPanel.repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    private static void createAndShowGui() {
        ProbMain2 mainPanel = new ProbMain2();

        JFrame frame = new JFrame("ProbMain2");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }

}


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