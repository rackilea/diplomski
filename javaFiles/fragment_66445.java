public class TestPane extends JPanel {

    public TestPane() {
        JLabel field = new JLabel("<html><a href='https://google.com'>Google it</a></html>");
        field.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(field, gbc);
        add(new JTextField(20), gbc);

        JPopupMenu menu = new JPopupMenu();
        menu.add(new CopyAction("https://google.com"));
        menu.add(new OpenAction("https://google.com"));
        field.setComponentPopupMenu(menu);
    }

    public class CopyAction extends AbstractAction {

        private String url;

        public CopyAction(String url) {
            super("Copy");
            this.url = url;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Toolkit tk = Toolkit.getDefaultToolkit();
            Clipboard cb = tk.getSystemClipboard();
            cb.setContents(new StringSelection(url), null);
        }

    }

    public class OpenAction extends AbstractAction {

        private String url;

        public OpenAction(String url) {
            super("Follow");
            this.url = url;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Desktop desktop = Desktop.getDesktop();
            if (desktop.isSupported(Action.BROWSE)) {
                try {
                    desktop.browse(new URL(url).toURI());
                } catch (IOException | URISyntaxException ex) {
                    ex.printStackTrace();
                }
            }
        }

    }

}