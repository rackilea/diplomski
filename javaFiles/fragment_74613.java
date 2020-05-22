public class FixedGui
    {
    public static void main(String[] argv)
        {
        final JFrame frame = new JFrame("Hello World");
        final JPanel panel = new JPanel();
        panel.add(new JLabel("Hello"), BorderLayout.NORTH);
        panel.add(new JLabel("World"), BorderLayout.SOUTH);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
        }
    }