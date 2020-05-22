import java.lang.reflect.Method;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

public class MenuTest {

    public static void main (String [] args) 
    {
        Display display = new Display ();
        final Shell shell = new Shell (display);
        final Menu bar = new Menu (shell, SWT.BAR);
        shell.setMenuBar (bar);

        final Composite c = new Composite(shell, SWT.NONE);
        c.setLayout(new GridLayout());
        c.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,true));

        MenuItem fileItem = new MenuItem (bar, SWT.CASCADE);
        fileItem.setText ("&File");
        Menu submenu = new Menu (shell, SWT.DROP_DOWN);
        fileItem.setMenu (submenu);
        MenuItem item = new MenuItem (submenu, SWT.PUSH);
        item.addListener (SWT.Selection, new Listener () {
            public void handleEvent (Event e) {
                System.out.println(shell.getSize().y -  shell.getClientArea().height);
                System.out.println(getMenuHeight(bar));
            }
        });


        item.setText ("Select &All\tCtrl+A");
        item.setAccelerator (SWT.MOD1 + 'A');
        shell.setSize (200, 200);
        shell.open ();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch ()) display.sleep ();
        }
        display.dispose ();
    }

    static int getMenuHeight(Menu parent)
    {
        try {
            Method m = Menu.class.getDeclaredMethod("getBounds", null);
            m.setAccessible(true);
            Rectangle r = (Rectangle) m.invoke(parent, null);
            return r.height;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}