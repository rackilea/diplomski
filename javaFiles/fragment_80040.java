public static void main(String[] args) {
    frame  = new JFrame("Checking Account Actions");
    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

    CheckingAccountActions panel = new CheckingAccountActions();

    MyWindowAdapter winAdapter = new MyWindowAdapter(panel);
    frame.addWindowListener(winAdapter);

    frame.getContentPane().add(panel);
    frame.pack();

    frame.setVisible(true);
}