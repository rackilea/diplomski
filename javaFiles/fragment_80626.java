public class Pong extends JFrame 
{
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame();
        Paneel panel = new Paneel();

        frame.setSize(1000, 800);
        frame.setLocation(500, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Pong");
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setContentPane(panel);
        frame.getContentPane().setBackground(Color.black);

        panel.printSizes();
    }
}