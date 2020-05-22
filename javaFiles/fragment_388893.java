public class MainWindow extends JFrame
{
  public MainWindow()
  {
    super("Fullscreen");
    getContentPane().setPreferredSize( Toolkit.getDefaultToolkit().getScreenSize());
    pack();
    setResizable(false);
    show();

    SwingUtilities.invokeLater(new Runnable() {
      public void run()
      {
        Point p = new Point(0, 0);
        SwingUtilities.convertPointToScreen(p, getContentPane());
        Point l = getLocation();
        l.x -= p.x;
        l.y -= p.y;
        setLocation(l);
      }
    });
  }
  ...
}