public static void main(String[] args)
{
    JFrame frame = new JFrame();

    JPanel panel = new JPanel(new MigLayout("debug"));
    panel.add(new JLabel("Label Title"), "x2 min(b1.x - unrel, (container.w+pref)/2)");
    panel.add(new JButton("Close Button"), "id b1, pushx, alignx right");
    panel.add(new JButton("Main Menu Button"), "alignx right");

    frame.add(panel);
    frame.setSize(800, 200);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setVisible(true);
}