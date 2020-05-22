public class MainPanel extends JPanel {

    private JTextField tI = new JTextField("Pourcentage");
    JPanel labelPanel = new JPanel();

    public MainPanel() {

        setLayout(new BorderLayout());
        tI.getDocument().addDocumentListener(new MyDocumentListener());
        add(tI, BorderLayout.PAGE_START);
        add(labelPanel);
    }

    private int check() {

        int numL;
        try {
            numL = Integer.parseInt(tI.getText());
        } catch (NumberFormatException exc) {
            return 0;
        }
        return numL > 100? 100 : numL;
    }

    private void update(int numL) {

        labelPanel.removeAll();
        for (int i = 0; i < numL; i++)
            labelPanel.add(new JLabel(String.valueOf(i+1)));

        JFrame mainWindow = ((JFrame) SwingUtilities.getWindowAncestor(this));
        mainWindow.pack();
        mainWindow.repaint();
    }

    class MyDocumentListener implements DocumentListener {

        @Override
        public void insertUpdate(DocumentEvent e) {

            update(check());
        }

        @Override
        public void removeUpdate(DocumentEvent e) {

            update(check());
        }

        @Override
        public void changedUpdate(DocumentEvent e) {

        }
    }
}