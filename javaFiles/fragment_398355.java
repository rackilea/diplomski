public class App
{

    private CustomPanel[] myCustomPanels = new CustomPanel[25];
    private int highlightedOne = -1;

    public static void main(String[] args)
    {
        new App();
    }

    App()
    {
        JFrame jFrame = new JFrame("Mouse Hover Demo");
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setLayout(new GridLayout(5,5));
        for(int i=0;i<25;i++)
        {
            CustomPanel toAdd = new CustomPanel(i);
            myCustomPanels[i] = toAdd;
            jFrame.add(toAdd);
        }
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
...