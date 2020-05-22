public static void main(String[] args) throws Exception {

    final JTextArea area = new JTextArea();

    JFrame frame = new JFrame("Test");

    frame.add(new JButton(new AbstractAction("Execute") {            
        @Override
        public void actionPerformed(ActionEvent e) {
            new MyWorker(area).execute();
        }
    }), BorderLayout.NORTH);

    frame.add(area, BorderLayout.CENTER);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);
    frame.setVisible(true);
}