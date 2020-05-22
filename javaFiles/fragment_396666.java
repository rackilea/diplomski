public class MyFrame extends JFrame
{   
    MyFrame()
    {
        setTitle("Frame Test");
        setSize(400, 200);
        setLayout(null);

        LeftPanel leftpanel = new LeftPanel();
        add(leftpanel);
        getRootPane().setDefaultButton(leftpanel.getDefaultBtn());

        setVisible(true);
        setDefaultCloseOperation(MyFrame.EXIT_ON_CLOSE);
    }
}