public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            JFrame mainFrame = new JFrame("test");
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //Opaque (default behaviour)
            Container pane = mainFrame.getContentPane();
            JTextPane jtp1 = new JTextPane();
            jtp1.setOpaque(true);
            jtp1.setText("this JTextPane is not transparent");
            jtp1.setEditable(false);

            //Not opaque (ie transparent)
            JTextPane jtp2 = new JTextPane();
            jtp2.setOpaque(false);
            jtp2.setText("this JTextPane is transparent");
            jtp2.setEditable(false);

            pane.setLayout(new FlowLayout());
            pane.setBackground(Color.LIGHT_GRAY);
            pane.add(jtp1);
            pane.add(jtp2);
            mainFrame.pack();
            mainFrame.setVisible(true);
        }
    });
}