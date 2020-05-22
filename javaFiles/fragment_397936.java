public static void main(String[] args) {
    JFrame f = new JFrame();
    f.setLayout(new FlowLayout());
    JLabel norm = new JLabel("Some text with some font");
    JLabel under = new JLabel("Underlined font");
    JLabel norm_again = new JLabel("Again font with no underline");

    f.getContentPane().add(norm);
    f.getContentPane().add(under);
    f.getContentPane().add(norm_again);
    f.pack();

    f.setLocationRelativeTo(null);
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Map attrs = norm.getFont().getAttributes();
    attrs.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
    under.setFont(norm.getFont().deriveFont(attrs));

    attrs = under.getFont().getAttributes();
    attrs.put(TextAttribute.UNDERLINE, -1);
    norm_again.setFont(under.getFont().deriveFont(attrs));
}