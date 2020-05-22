public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
            buildGUI();
        }
    });
}

private static void buildGUI() {
    JFrame f = new JFrame("Test");
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    ComponentResizer cr = new ComponentResizer();
    JPanel mainPanel = new JPanel(null);
    f.add(mainPanel);

    JTextArea textArea = new JTextArea("Some text\nSome other text");
    cr.registerComponent(textArea);

    mainPanel.add(textArea);
    textArea.setBounds(50, 50, 150, 150);

    f.setSize(400, 400);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
}