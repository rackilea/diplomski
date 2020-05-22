public class BadGui
    {
    public static void main(String[] argv)
        {
        final JFrame frame = new JFrame("Hello World");
        final JPanel panel = new JPanel();
        panel.add(new JLabel("Hello"), BorderLayout.NORTH);
        panel.add(new JLabel("World"), BorderLayout.SOUTH);
        frame.setVisible(true);
        }
    }