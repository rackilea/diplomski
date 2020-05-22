public static void main(String[] args) {

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    frame.setPreferredSize(new Dimension(600,600));
    frame.setLayout(new GridLayout(8, 8, 0, 0));
    frame.getContentPane().setBackground(Color.green);

    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            frame.add(new Square(0, 0, (i+j)%2==0 ? Color.RED : Color.BLACK));
        }
    }   

    frame.pack();
    frame.setVisible(true);
}