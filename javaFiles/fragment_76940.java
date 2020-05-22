public class ToutrialStart extends JFrame implements ActionListener
{
Container contentPane = getContentPane();
public void schoolDecider()
{
    contentPane.setLayout(null);
    contentPane.setBackground(Color.BLACK);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(1024, 600);
    setLocation(0,0);
    setTitle("Title");
    setResizable(false);
}
}
public class touDia extends JFrame implements actionListener
{
    public void school()
    {
        new ToutrialStart().schoolDecider();
    }
}