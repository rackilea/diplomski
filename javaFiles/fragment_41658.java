import javax.swing.JFrame;


public abstract class MyFrameManager {
    static private JFrame   startFrame,
                        anotherFrame,
                        justAnotherFrame;

static public synchronized JFrame getStartFrame()
{
    if(startFrame == null)
    {
        //frame isnt initialized, lets do it
        startFrame = new JFrame();
        startFrame.setSize(42, 42);
        //...
    }

    return startFrame;
}

static public synchronized JFrame getAnotherFrame()
{
    if(anotherFrame == null)
    {
        //same as above, init it
    }

    return anotherFrame;
}

static public synchronized JFrame getJustAnotherFrame()
{
    //same again
    return justAnotherFrame;
}

public static void main(String[] args) {
    //let's test!

    JFrame start = MyFrameManager.getStartFrame();
        start.setVisible(true);

    //want another window
    JFrame another = MyFrameManager.getAnotherFrame();
        another.setVisible(true);

    //oh, doenst want start anymore
    start.setVisible(false);
}
}