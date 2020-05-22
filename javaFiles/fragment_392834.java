public class SwingApp
{
  public static void main(String[] args)
  {
    final JFrame frame = new JFrame("Swing App");

    SwingUtilities.invokeLater(new Runnable()
    {
      public void run()
      {
        final SuperHeroGameLoop loop = new SuperHeroGameLoop();

        frame.getContentPane().add(loop);
        frame.setSize(320, 240);

        loop.init();

        frame.setVisible(true);
      }
    });
  }
}