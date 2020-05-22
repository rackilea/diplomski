package test;

import org.eclipse.swt.widgets.Display;

public class Main 
{

    public static void main(String[] args) throws Exception
    {
        final GUIThread gui = new GUIThread();
        Thread t = new Thread(gui);
        t.start();

        Thread.sleep(3000); // POINT OF FOCUS
        Display d = gui.getDisplay();

        for(int i = 0; i<100; i++)
        {           
            System.out.println(i + "  " + d);
            gui.update(i);  
            Thread.sleep(500);
        }
    }
}