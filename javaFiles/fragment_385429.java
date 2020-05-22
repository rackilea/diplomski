public static void main(String s[]) {
    JFrame frame = new JFrame("Hello");
    frame.setLayout(new FlowLayout());
    frame.add(new Veldmaker(100,100, "yourImage"));
    frame.setSize(300, 300);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
}