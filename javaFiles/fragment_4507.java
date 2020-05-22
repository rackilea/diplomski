import org.eclipse.swt.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;

public class ShapeText 
{
    public static void main(String[] args) 
    {
        final Display display = new Display();
        Font font = new Font(display, "Times", 50, SWT.BOLD);
        final Color blue = display.getSystemColor(SWT.COLOR_BLUE);
        final Path path;
        try {
            path = new Path(display);
            path.addString("The Starry Night", 0, 0, font);
        } catch (SWTException e) {
            System.out.println(e.getMessage());
            display.dispose();
            return;
        }

        Shell shell = new Shell(display);
        shell.addListener(SWT.Paint, new Listener() 
        {
            public void handleEvent(Event e) 
            {           
                GC gc = e.gc;

                //Transform a = new Transform(display);
                //a.shear(0.7f, 0f);
                //gc.setTransform(a);
                gc.setForeground(blue);
                gc.fillPath(path);
                gc.drawPath(path);
            }
        });

        shell.setSize(530,120);

        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }

        path.dispose();
        font.dispose();
        display.dispose();
    }
}