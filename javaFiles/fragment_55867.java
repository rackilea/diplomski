class Main {
    private static boolean listChanging = false;

    public static void createGUI() {
        final JFrame f = new JFrame();
        JList<String> list = new JList<String>(new String[] { "Text A", "Text B" });
        list.setFont(list.getFont().deriveFont(24f));
        list.setDragEnabled(true);
        list.setTransferHandler(new TransferHandler() {
            private static final long serialVersionUID = 1L;

            @Override
            public int getSourceActions(JComponent c) {
                if (listChanging) {
                    listChanging = false;
                    return NONE;
                } else {
                    return COPY;
                }
            }

            @Override
            @SuppressWarnings("unchecked")
            public Transferable createTransferable(JComponent c) {
                return new StringSelection(((JList<String>) c).getSelectedValue());
            }
        });
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                f.setLocation(f.getX(), f.getY() + f.getHeight());
                listChanging = true;
            }
        });
        list.setSelectedIndex(0);
        f.add(list, BorderLayout.CENTER);
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationByPlatform(true);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main.createGUI();
            }
        });
    }
}