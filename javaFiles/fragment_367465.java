JFrame f = new JFrame();
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
JButton b = new JButton("Test");
b.setEnabled(false);
b.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("action performed");
    }
});
b.addMouseListener(new MouseAdapter() {
    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("clicked");
    }
});
f.add(b);
f.pack();
f.setVisible(true);