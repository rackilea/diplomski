public static void main(String[] args) {
    JFrame f = new JFrame();
    TestA b = new TestA("X");
    JPanel buttonContainer = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
    buttonContainer.setBackground(Color.GREEN);
    buttonContainer.add(b);
    f.add(buttonContainer);
    f.pack();
    f.setVisible(true);
}