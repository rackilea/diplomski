@Override
public Dimension getPreferredSize()
{
    int width = Toolkit.getDefaultToolkit().getScreenSize().width / 2;
    int height = Toolkit.getDefaultToolkit().getScreenSize().height;
    return new Dimension(width, height);
}