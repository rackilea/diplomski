public class RandomWalk extends JPanel
{
final int   range   = 50;//max space to move in width or height
final int   num     = 50;//number of line-1 to draw
final int[] ax      = new int[num];
final int[] ay      = new int[num];

public RandomWalk(final int width, final int height)
{

    final Random rand = new Random();//better to use Random. Easier to debug since you can set a seed

    // lets set first point in the middle
    ax[0] = width / 2;
    ay[0] = height / 2;

    // generating random point
    for (int i = 1; i < num; i++)
    {
        //make sure that we dont go outside the bound of the panel
        ax[i] = (int) Math.max(0, Math.min(width, ax[i - 1] + ((rand.nextFloat() - .5f) * range)));
        ay[i] = (int) Math.max(0, Math.min(height, ay[i - 1] + ((rand.nextFloat() - .5f) * range)));
    }

}

public void paintComponent(Graphics g)
{

    g.setColor(Color.black);
    for (int i = 1; i < num; i++)
        g.drawLine((int) ax[i - 1], (int) ay[i - 1], (int) ax[i], (int) ay[i]);

}

public static void main(String[] args)
{
    // Generates frame.
    JFrame frame = new JFrame();

    // Sets frame resolution and other parameters.
    frame.setSize(300, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    RandomWalk panel = new RandomWalk(frame.getWidth(), frame.getHeight());
    frame.getContentPane().add(panel);
    frame.setVisible(true);
     frame.setResizable(false);
}